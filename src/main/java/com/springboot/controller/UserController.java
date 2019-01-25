package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	
	@RequestMapping("/query-annotations")
	public List<User> addUser() {
		
		//https://www.baeldung.com/spring-data-jpa-query
		List<User> userList = null;
		// Sorting 
		userList = userRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
		// user define sorting
		userList = userRepository.findAllUsers(new Sort("name"));
		// Indexed Query Parameters
		userList = userRepository.findByNamesIndexedJPQL("jeet", "test");
		userList = userRepository.findByNamesIndexedSQL("jeet", "test");
		// Named Parameters
		userList = userRepository.findByNamesNamedJPQL("jeet", "test");
		userList = userRepository.findByNamesNamedSQL("jeet", "test");
		return null;
	}
}
