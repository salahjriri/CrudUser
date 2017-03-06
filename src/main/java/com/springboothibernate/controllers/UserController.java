package com.springboothibernate.controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.springboothibernate.model.User;
import com.springboothibernate.dao.UserService;

@Controller
@Path("/user")
public class UserController {
	@Autowired
	User user;
	
	@Autowired
	private UserService userService;
	
	@GET
	@Path("/list")
	@Produces("application/json")  
	public List<User> getUsers(){
		return userService.findAll();
	}
	
	
	@GET
	@Path("/add/{userName}/{age}")
	@Produces("application/json") 
	public User addUser(@PathParam("userName") String userName,@PathParam("age") int age)
	{
		user.setAge(age);
		user.setUserName(userName);
		return userService.save(user);
	}
	@GET
	@Path("/update/{userId}/{userName}/{age}")
	@Produces("application/json") 
	public User UpdateUser(@PathParam("userId") int userId ,@PathParam("userName") String userName,@PathParam("age") int age)
	{
		
		
		if(userService.exists(userId)){
			user = userService.findOne(userId);
			user.setUserName(userName);
			user.setAge(age);
		userService.save(user);}
		return user;
	}
	@GET
	@Path("/deleteUser/{userId}")
	public void DeleteUser(@PathParam("userId") int userId )
	{
		if(userService.exists(userId)){
			userService.delete(userId);
		}
	
	}
	
	
	

	
}
