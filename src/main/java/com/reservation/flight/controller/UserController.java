package com.reservation.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reservation.flight.entity.User;
import com.reservation.flight.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/registerUser")
	public String showRegistrationPage() {
		return "user/registerUser";
	}

	@PostMapping("/registerUsers")
	public String register(@ModelAttribute("user") User user) {
		userRepository.save(user);
		return "user/login";
	}
	
	@GetMapping("login")
	public String showLoginPage() {
		return "user/login";
	}
    @PostMapping("/log")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap) {
        List
        <User> users = userRepository.findByEmail(email);

        if (users.isEmpty()) {
            modelMap.addAttribute("msg", "User not found");
            return "user/login";
        }

        for (User user : users) {
            if (user.getPassword().equals(password)) {
                return "flight/findFlight";
            }
        }

        modelMap.addAttribute("msg", "Invalid Password");
        return "user/login";
    }

}
