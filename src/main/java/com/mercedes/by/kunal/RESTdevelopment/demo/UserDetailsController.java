package com.mercedes.by.kunal.RESTdevelopment.demo;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;




// Need to test if --> trying to create List of Users and want to expose it with an /user/ API.
//
@RestController
public class UserDetailsController {
//
//    UserDetailsService userDetailsService;

//    Hardcoaded User Details
//    @GetMapping("/users/")
//    public List<UserDetails> getAllUsers()
//    {
//        UserDetails user1 = User
//                .withUsername("Ramu")
//                .roles("USER")
//                .build();
//
//        UserDetails user2 = User
//                .withUsername("surekha")
//                .roles("USER")
//                .build();
//
//        return Arrays.asList(user1,user2);
//    }


//Trying to create a controller that fetch users which is stored in InMemoryUserDetailsManager.
public final UserDetailsService userDetailsService;

    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/users/{user_name}")
public UserDetails getUsersFromInMemory(@PathVariable String user_name)
{
 return userDetailsService.loadUserByUsername(user_name);

}



}
