package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Company;
import com.springboot.model.User;
import com.springboot.repository.CompanyRepository;
import com.springboot.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/add-company")
	public Company addCompany(@RequestBody Company company) {
		return companyRepository.save(company);
	}
	
	@RequestMapping("/add-user")
	public User addUser(@RequestBody User user) {
		return userRepository.save(user);
	}
}
