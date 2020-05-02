package com.capgemini.UserLogin.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.UserLogin.Service.ServiceMain;
import com.capgemini.UserLogin.entity.User;



@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:4200")
public class Controller {

	
	@Autowired
	ServiceMain service;
	
	@GetMapping("/UserLogin/{userId},{password}")
	public String UserLogin(@PathVariable("userId") String userId,@PathVariable("password") String password) {
		Optional<User> u = service.userLogin(userId,password);
		/*if (u == null) {
			//throw new UserExceptions("Update Operation Unsuccessful,Provided UserId does not exist");
			return new ResponseEntity<String>("UserId and password are incorrect", new HttpHeaders(), HttpStatus.OK);
		
		} else 
			return new ResponseEntity<String>( "Logged in Successfully", new HttpHeaders(), HttpStatus.OK);
		}*/
		return u.toString();
		
	}
}

