package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Company;
import com.springboot.model.User;
import com.springboot.repository.CompanyRepository;
import com.springboot.repository.UserRepository;

@RestController
public class IndexController {
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/")
	public String welcome() {
		
		/*Company obj = new Company();
		obj.setName("xyz");
		companyRepository.save(obj);*/

		List<Company> companyList = companyRepository.findAll();
		User user1 = new User();
		user1.setName("jeet");
		user1.setEmail("jeet@gmail.com");
		user1.setNumber("1231231231");
		user1.setPassword("jeet");
		user1.setCompanies(companyList);
		userRepository.save(user1);
		return "welcome to the app";
	}
}