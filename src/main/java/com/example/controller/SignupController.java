package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.service.UserApplicationService;

@Controller
@RequestMapping("/user")
public class SignupController {
	@Autowired
	private UserApplicationService userApplicationService;
	
	/** Display the user signup screen **/
	@GetMapping("/signup")
	public String getSignup(Model model) {
		Map<String, Integer> genderMap = userApplicationService.getGenderMap(null);
		model.addAttribute("genderMap", genderMap);
		return "user/signup";
	}
	
	@PostMapping("/signup")
	public String postSignup() {
		return "redirect:/login";
	}
}
