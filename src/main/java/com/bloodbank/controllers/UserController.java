package com.bloodbank.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class UserController {
	@GetMapping(path="/home")
	public String homePage() {
		return "public/home";
	}
	
	@GetMapping(path="/")
	public String defultPage() {
		return "public/home";
	}
	
	@GetMapping(path="/login")
	public String loginPage() {
		return "public/login";
	}
	
}
