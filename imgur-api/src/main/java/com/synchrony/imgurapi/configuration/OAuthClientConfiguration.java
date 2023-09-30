package com.synchrony.imgurapi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.registration.*;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class OAuthClientConfiguration {

    @Bean
    ReactiveClientRegistrationRepository imgurClientRegistration(
            @Value("${spring.security.oauth2.client.provider.imgur-service.token-uri}") String token_uri,
            @Value("${spring.security.oauth2.client.registration.imgur-service.client-id}") String client_id,
            @Value("${spring.security.oauth2.client.registration.imgur-service.client-secret}") String client_secret,
            @Value("${spring.security.oauth2.client.registration.imgur-service.scope}") String scope,
            @Value("${spring.security.oauth2.client.registration.imgur-service.authorization-grant-type}") String authorizationGrantType,
            @Value("${spring.security.oauth2.client.registration.imgur-service.authorization-uri}") String authorization_uri,
            @Value("${spring.security.oauth2.client.registration.imgur-service.redirect-uri}") String redirect_uri
    ) {
        ClientRegistration clientRegistration = ClientRegistration
                .withRegistrationId("imgur-service")
                .tokenUri(token_uri)
                .clientId(client_id)
                .clientSecret(client_secret)
                .scope(scope)
                .authorizationGrantType(new AuthorizationGrantType(authorizationGrantType))
                .authorizationUri(authorization_uri)
                .redirectUri(redirect_uri)
                .build();

        return new InMemoryReactiveClientRegistrationRepository(clientRegistration);
    }

    @Bean
    WebClient webClient(ReactiveClientRegistrationRepository clientRegistrations) {
        InMemoryReactiveOAuth2AuthorizedClientService clientService = new InMemoryReactiveOAuth2AuthorizedClientService(clientRegistrations);
        AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager authorizedClientManager = new AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager(clientRegistrations, clientService);
        ServerOAuth2AuthorizedClientExchangeFilterFunction oauth = new ServerOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManager);
        oauth.setDefaultClientRegistrationId("imgur-service");
        return WebClient.builder()
                .filter(oauth)
                .build();
    }
}
