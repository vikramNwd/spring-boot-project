package com.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.services.UserService;

import jakarta.servlet.http.HttpSession;

/*
  DaoAuthentication : validation against database(in-built, validation logic)
  JwtAuthentication :
  OAuth2Authentication : 
  LDapAuthentication :
  
  
  any request ==> global, route-specific
  /profile ==> intercept(security filter) ==> check user logged in ==> /login(FormLogin)
 */

/*
 	foramp abc123 USER
 	rams xyz123 ADMIN
 */

@RestController
public class MainController {

	@Autowired
	UserService userService;
	
	
	@GetMapping("/home")
	String homehandler() {
		return "This is home page";
	}
	
	@GetMapping("/welcome")
	String welcomeHandler() {
		return "This is welcome page";
	}
	
	@GetMapping("/user/profile")
	String userProfilehandler() {
		return "This is user profile page";
	}
	
	@GetMapping("/admin/dashboard")
	String adminDashboardHandlerhandler() {
		return "This is admin dashboard page";
	}
	

	
}