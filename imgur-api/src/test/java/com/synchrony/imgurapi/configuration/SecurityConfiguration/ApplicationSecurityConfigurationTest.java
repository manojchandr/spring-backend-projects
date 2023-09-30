package com.synchrony.imgurapi.configuration.SecurityConfiguration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ApplicationSecurityConfiguration.class})
@ExtendWith(SpringExtension.class)
class ApplicationSecurityConfigurationTest {
    @Autowired
    private ApplicationSecurityConfiguration applicationSecurityConfiguration;

    /**
     * Method under test: {@link ApplicationSecurityConfiguration#userDetailsService()}
     */
    @Test
    void testUserDetailsService() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     InMemoryUserDetailsManager.authenticationManager
        //     InMemoryUserDetailsManager.logger
        //     InMemoryUserDetailsManager.securityContextHolderStrategy
        //     InMemoryUserDetailsManager.users

        assertFalse((new ApplicationSecurityConfiguration()).userDetailsService().userExists("janedoe"));
    }

    /**
     * Method under test: {@link ApplicationSecurityConfiguration#encoder()}
     */
    @Test
    void testEncoder() {
        assertTrue(applicationSecurityConfiguration.encoder() instanceof BCryptPasswordEncoder);
    }

    /**
     * Method under test: {@link ApplicationSecurityConfiguration#securityFilterChain(HttpSecurity)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSecurityFilterChain() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: objectPostProcessor cannot be null
        //   See https://diff.blue/R013 to resolve this issue.

        AuthenticationManagerBuilder authenticationBuilder = new AuthenticationManagerBuilder(null);
        applicationSecurityConfiguration
                .securityFilterChain(new HttpSecurity(null, authenticationBuilder, new HashMap<>()));
    }
}

