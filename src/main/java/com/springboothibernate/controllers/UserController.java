package com.springboothibernate.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboothibernate.model.User;
import com.springboothibernate.dao.UserService;

@RestController
public class UserController {
	@Autowired
	User user;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public List<User> getUsers(){
		return userService.findAll();
	}
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public User addUser(@RequestParam String users ){
				String []userArry = users.split(",");
				user.setUserName(userArry[0]);
				user.setAge(Integer.valueOf(userArry[1]));
				return userService.save(user);
	}
	@RequestMapping(value = "/updateUser", method = RequestMethod.GET)
	public User updateUser(@RequestParam String users ){
				String []userArry = users.split(",");
				
				if(userService.exists(Integer.valueOf(userArry[0]))){
				user = userService.findOne(Integer.valueOf(userArry[0]));
				user.setUserName(userArry[1]);
				user.setAge(Integer.valueOf(userArry[2]));
				return userService.save(user);
				}
				else {
					user.setUserName(userArry[0]);
					user.setAge(Integer.valueOf(userArry[1]));
					return userService.save(user);
				}
		}
			
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public void deleteUser(@RequestParam String userId){
		if(userId.equals(null)){ return ;}
		else {
		String[] b = userId.split(",");
		if(userService.exists(Integer.valueOf(b[0])))
		userService.delete(Integer.valueOf(b[0]));
	}
	
}}
