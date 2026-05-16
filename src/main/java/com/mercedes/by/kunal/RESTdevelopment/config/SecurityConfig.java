package com.mercedes.by.kunal.RESTdevelopment.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
//@EnableWebSecurity  -- search
public class SecurityConfig {

@Bean
    public SecurityFilterChain filterChain(HttpSecurity httpsecurity)
    {
        httpsecurity
//                .csrf(csrf -> csrf.ignoringRequestMatchers("/api/csrf"))    //Ignoring CSRF
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().authenticated() //needs to be authenticated
                                .anyRequest().permitAll()  //For all permitted without login
                );
//                .formLogin(Customizer.withDefaults()); //For Login

        return httpsecurity.build();
    }


//  InMemoryUserDetail
    //Need to apply passwordEncoder
@Bean
public UserDetailsService inMemoryUsers() {

    UserDetails user1 = User
            .withUsername("Ramu")
            .password("{noop}Ramu@123")
//            .passwordEncoder(p -> "{noop}" + p)
            .roles("USER")
            .build();


    UserDetails user2 = User
            .withUsername("Surekha")
            .password("{noop}Surekha@123")
//            .passwordEncoder(p -> "{noop}" + p)
            .roles("USER")
            .build();

    UserDetails user3 = User
            .withUsername("Hemant")
            .password("{noop}Hemant@123")
//            .passwordEncoder(p -> "{noop}" + p)
            .roles("USER")
            .build();


    UserDetails bittuUser = User
            .withUsername("bittuUser")
            .password("{noop}bittuUser@123")
//            .passwordEncoder(p -> "{noop}" + p)
            .roles("ADMIN")
            .build();

    UserDetails kunalUser = User
            .withUsername("kunalUser")
            .password("{noop}kunalUser@123")
//            .passwordEncoder(p -> "{noop}" + p)
            .roles("ADMIN")
            .build();



    return new InMemoryUserDetailsManager(user1,user2,user3, bittuUser, kunalUser);

    }





}
