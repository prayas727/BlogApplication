package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Services.UserServiceImpl;
import com.example.demo.binding.LoginData;
import com.example.demo.binding.Registration;

@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping("/login")
	public String getloginPage(Model model) {
		LoginData loginData = new LoginData();
		model.addAttribute("loginData", loginData);
		return "Login";
	}

	@PostMapping("savelogin")
	public String saveloginPage(@ModelAttribute LoginData loginData) {
		System.out.println(loginData);
		System.out.println(userServiceImpl.verifyUserData(loginData));
		return "Login";
	}

	@GetMapping("/registration")
	public String getRegistrationPage(Model model) {
		Registration registration = new Registration();
		model.addAttribute("registration", registration);
		return "Registration";
	}

	@PostMapping("saveRegister")
	public void saveRegister(@ModelAttribute Registration registration) {
		System.out.println(registration);
		userServiceImpl.saveUserData(registration);

	}
}
