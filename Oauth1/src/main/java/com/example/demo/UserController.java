package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserServiceImpl;

@RestController
public class UserController {
	   @Autowired
	    private UserServiceImpl userService;

	    @RequestMapping(value="/user", method = RequestMethod.GET)
	    public List listUser(){
	        return userService.findAllUsers();
	    }

	    @RequestMapping(value = "/user", method = RequestMethod.POST)
	    public void create(@RequestBody User user){
	        userService.saveUser(user);
	    }

	    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	    public String delete(@PathVariable(value = "id") Long id){
	        userService.deleteUserById(id);
	        return "success";
	    }

}
