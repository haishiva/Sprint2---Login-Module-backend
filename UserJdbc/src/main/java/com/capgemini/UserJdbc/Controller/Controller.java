package com.capgemini.UserJdbc.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.UserJdbc.Exceptions.UserExceptions;
import com.capgemini.UserJdbc.Service.ServiceMain;
import com.capgemini.UserJdbc.entity.User;


@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:4200")
public class Controller {

	@Autowired
	ServiceMain service;
	
	@PostMapping("/UserRegistration")
	public ResponseEntity<String> UserRegistration(@RequestBody User user) {
		User u = service.userRegistration(user);
		if (u == null) {
			//throw new UserExceptions("UserId already exist");
			return new ResponseEntity<String>("UserId already exist", new HttpHeaders(), HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("User created successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	
	

	// Updating Employee data
	@GetMapping("/PasswordRecovery/{userId},{password},{rePassword}")
	public ResponseEntity<String> passwordRecovery(@PathVariable("userId") String userId,@PathVariable("password") String password,@PathVariable("rePassword") String rePassword) {
		int u = service.passwordRecovery(userId,password,rePassword);
		if (u == 0) {
			//throw new UserExceptions("Update Operation Unsuccessful,Provided UserId does not exist");
			return new ResponseEntity<String>("Update Operation Unsuccessful,Provided UserId does not exist", new HttpHeaders(), HttpStatus.OK);
		
		} else {
			return new ResponseEntity<String>("Password updated successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Deleting Employee
	@GetMapping("/UserLogout/{userId}")
	private ResponseEntity<String> userLogout(@PathVariable("userId") String userId) {
		String u = service.userLogout(userId);
		if (u == null) {
			return new ResponseEntity<String>("Logout Unsuccessful,Provided Id not logged in", new HttpHeaders(), HttpStatus.OK);
			
		//throw new UserExceptions("Logout Unsuccessful,Provided Id not logged in");
		} else {
			return new ResponseEntity<String>("Logged out successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	@ExceptionHandler(UserExceptions.class)
	public ResponseEntity<String> userNotFound(UserExceptions e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
