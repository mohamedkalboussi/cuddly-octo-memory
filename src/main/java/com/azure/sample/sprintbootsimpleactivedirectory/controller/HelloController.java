package com.azure.sample.sprintbootsimpleactivedirectory.controller;

import com.azure.sample.sprintbootsimpleactivedirectory.config.AuthenticationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
public class HelloController {

     @Autowired
     private AuthenticationManager authenticationManager;

     @GetMapping("admin")
     @PreAuthorize("hasAuthority('APPROLE_Admin')")
     public String admin() {
          return "This resource is accessible only for the users of the group 'Admin'. " + authenticationManager.getCurrentUser();
     }

     @GetMapping("rh")
     @PreAuthorize("hasAuthority('APPROLE_RH')")
     public String rh() {
          return "This resource is accessible only for the users of the group 'RH'. " + authenticationManager.getCurrentUser();
     }
}