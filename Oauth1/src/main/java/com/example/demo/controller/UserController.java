package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserServiceImpl;

@RestController
public class UserController {
	   @Autowired
	    private UserServiceImpl userService;

	    @RequestMapping(value="/user/list", method = RequestMethod.GET)
	    public List listUser(){
	        return userService.findAllUsers();
	    }

	    @RequestMapping(value = "/user", method = RequestMethod.POST)
	    public void create(@RequestBody User user){
	        userService.saveUser(user);
	    }

	    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	    public List delete(@PathVariable(value = "id") String id){
	    	return userService.findAllUsers();
	    }
	    
	    @RequestMapping(value = "/user/user-by-name", method = RequestMethod.GET)
	    public User getUserById(@RequestParam(value = "username") String name){
	        //userService.findByName(id);
	        return userService.findByName(name);
	    }

}
