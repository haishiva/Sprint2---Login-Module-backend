package com.capgemini.UserLogin.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.UserLogin.Dao.DaoClass;
import com.capgemini.UserLogin.entity.User;


@Service
@Transactional
public class ServiceMain {

	@Autowired
	DaoClass dao;
	
	
	public Optional<User> userLogin(String userId,String password)
	{
		
		
		
		return dao.userLogin(userId, password);
		
		
	}
	
}
