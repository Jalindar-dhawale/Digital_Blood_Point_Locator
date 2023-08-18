package com.jalindar1.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jalindar1.model.BloodbankDtls;
import com.jalindar1.model.UserDtls;
import com.jalindar1.repository.BbRepository;
import com.jalindar1.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	@Autowired
	private BbRepository bbrepo;
	
	@ModelAttribute
	private void userDetails(Model m, Principal p) {
		String email = p.getName();
		UserDtls user = userRepo.findByEmail(email);

		m.addAttribute("user", user);

	}
	
	
	@GetMapping("/")
	public String home() {
		//List<HospitalDtls> list=userRepo.findAll();
		
		return "user/home";
	}
	@GetMapping("/searchBloodbank")
	public String getBloodBank(Model m) {
		List<BloodbankDtls> list1=bbrepo.findAll();
		m.addAttribute("all_bloodbank",list1);
		return "user/SearchBloodbank";
	}
	@GetMapping("/changePass")
	public String loadChangePassword() {
		return "user/change_password";
	}
	
	@PostMapping("/updatePassword")
	public String changePassword(Principal p,@RequestParam("oldPass") String oldPass,@RequestParam("newPass") String newPass,HttpSession session) {
		
		String email=p.getName();
	UserDtls loginUser=	userRepo.findByEmail(email);
	boolean f=passwordEncode.matches(oldPass,loginUser.getPassword());
	
	if(f) {
		loginUser.setPassword(passwordEncode.encode(newPass));
		UserDtls updatePasswordUser=userRepo.save(loginUser);
		
		if(updatePasswordUser!=null) {
			session.setAttribute("msg", "Password Changed Successfully");
			
		}
		else {
			session.setAttribute("msg", "Something error on server	");

		}
	}
	else {
		session.setAttribute("msg", "Old Password is Incorrect");
	}
		return "redirect:/user/changePass";
	}
}
