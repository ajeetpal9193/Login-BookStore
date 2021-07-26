package com.bookstore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@Autowired
	private LoginRepo loginrepo;
	
	@GetMapping("")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("loginuser", new Login());
	    return "signup";
	}
	
	@PostMapping("/processRegister")
	public String processRegister(Login loginuser) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(loginuser.getPassword());
		loginuser.setPassword(encodedPassword);
	    loginrepo.save(loginuser);
	    return "register";
	}
	
	@GetMapping("/users")
	public String viewUserList(Model model) {
		List<Login> viewuserslist = loginrepo.findAll();
		model.addAttribute("userslist", viewuserslist);
		return "listofusers";
		
	}
	
}
