package com.jalindar1.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jalindar1.model.UserDtls;
import com.jalindar1.repository.UserRepository;
import com.jalindar1.service.UserService;

@Controller
public class HomeController { 
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@ModelAttribute
	private void userDetails(Model m, Principal p) {
		if(p!=null) {
		String email = p.getName();
		UserDtls user = userRepo.findByEmail(email);

		m.addAttribute("user", user);
		} 
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/about_us")
	public String AboutUs() {
		return "AboutUs";
	}
	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@PostMapping("/createUser")
	public String createuser(@ModelAttribute UserDtls user,HttpSession session) {
		
		boolean f=userService.ckeckEmail(user.getEmail());
		
		if(f) {
			session.setAttribute("msg", "Email Id alreday exists");
		}
		else {
		
	UserDtls userDtls=userService.createUser(user);
	if(userDtls != null) {
		session.setAttribute("msg", "Register Sucessfully");	}
	else
	{
		session.setAttribute("msg", "Something wrong on server");
	}
	}
		return "redirect:/register";
	}
	
	
	@GetMapping("/loadForgotPassword")
	public String loadForgotPassword() {
		
		
		return "/user/forgot_password";
	}
	@GetMapping("/loadResetPassword/{id}")
public String loadResetPassword(@PathVariable int id,Model m) {
		m.addAttribute("id",id);
		
		
		return "/user/reset_password";
	}
	@PostMapping("/forgotPassword")
	public String forgotPassword(@RequestParam String email,@RequestParam String mobileNumber,HttpSession session) {
		UserDtls user=userRepo.findByEmailAndMobileNumber(email, mobileNumber);
		
		if(user!=null) {
			return "redirect:/loadResetPassword/"+user.getId();
		}
	
		else {
			session.setAttribute("msg", "Invalid Email & Mobile Number");
			return "/user/forgot_password";
		}
	}
	@PostMapping("/changePassword")
	public String resetPassword(@RequestParam String psw,@RequestParam Integer id,HttpSession session) {
		UserDtls user=userRepo.findById(id).get();
		
		String encryptPsw=passwordEncoder.encode(psw);
		user.setPassword(encryptPsw);
		
		UserDtls updateUser=userRepo.save(user);
		if(updateUser!=null) {
			session.setAttribute("msg", "Password Change Successfully");
		}
		
		return "rediect:/loadForgotPassword";
	}
}
