package com.example.webseverjavatyang.services;
import com.example.webseverjavatyang.models.*;

import com.example.webseverjavatyang.repositories.UserRepository;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserService {
	// grab user repository
	
	@Autowired
	UserRepository userRepository;
	
	
	@PostMapping("/register")
    public User register(@RequestBody User user, HttpSession session) {
		User cu = userRepository.save(user); //save user to the sql
		session.setAttribute("currentUser", cu);
		return cu;
    }
	
	@GetMapping("/checkLogin")
	public User checkLogin(HttpSession session) {
		return (User) session.getAttribute("currentUser");
	}
	
	@GetMapping("/api/user/{userId}")
	public Optional<User> findUserByUserId(@PathVariable("userId") String userId) {
		//get user from the repository by its id
		int id = Integer.parseInt(userId);
		return userRepository.findById(id);
	}
	
	@PostMapping("/login")
    public User login(@RequestBody User user) {
		return userRepository.findUserByCredentials(user.getUsername(), user.getPassword());
    }
	
	@GetMapping("/api/user")
	public List<User> findAllUsers(){
		return (List<User>) userRepository.findAll();
		
	}
}
