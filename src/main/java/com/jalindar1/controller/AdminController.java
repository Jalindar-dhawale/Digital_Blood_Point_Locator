package com.jalindar1.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jalindar1.model.BloodbankDtls;
import com.jalindar1.model.UserDtls;
import com.jalindar1.repository.BbRepository;
import com.jalindar1.repository.UserRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BbRepository bbrepo;

	@GetMapping("/")
	public String home(Model m) {
		List<UserDtls> list=userRepo.findAll();
		m.addAttribute("all_Users",list);
		return "admin/home";
	}
	
	@GetMapping("/delete/{id}")
	public String DeleteUser(@PathVariable(value ="id") int id,HttpSession session) {
		userRepo.deleteById(id);
		session.setAttribute("msg","user deleted successfully");
		
		return "redirect:/admin/";
	}
	@GetMapping("/bb_index")
	public String BbHome(Model m) {
		
		List<BloodbankDtls> list1=bbrepo.findAll();
		m.addAttribute("all_bloodbank",list1);
		return "admin/BbIndex";
	
	}
	@GetMapping("/bb_add")
	public String BbAdd() {
		
		return "admin/BbAdd";
	
	}
	@GetMapping("/bb_edit/{id}")
	public String BbEdit(@PathVariable(value = "id")long id,Model m) {
		Optional<BloodbankDtls> bloodbankdtls=bbrepo.findById(id);
		BloodbankDtls bbd=bloodbankdtls.get();
		m.addAttribute("bloodbank",bbd);
		
		return "admin/BbEdit";
	
	}
	
	@PostMapping("/save_bloodbanks")
	public String SaveBloodBank(@ModelAttribute BloodbankDtls Bbs,HttpSession session) {
		bbrepo.save(Bbs);
		session.setAttribute("msg", "BloodBank Added Successfully");
		
		
		
		return "redirect:/admin/bb_add";
	}
	
	
	@PostMapping("/updatebloodbank")
	public String UpdateBloodBank(@ModelAttribute BloodbankDtls Bbs,HttpSession session) {
		bbrepo.save(Bbs);
		session.setAttribute("msg", "BloodBank Updated Successfully");
		
		
		
		return "redirect:/admin/bb_index";
	}
	
	
	@GetMapping("/bb_delete/{id}")
	public String deleteBloodbank(@PathVariable(value = "id") long id,HttpSession session){
		
		bbrepo.deleteById(id);
		session.setAttribute("msg", "BloodBank Deleted Successfully");

		
		return "redirect:/admin/bb_index";
		
	}
	
	
}

