package com.capgemini.UserJdbc.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.UserJdbc.DaoImpl.Dao;
import com.capgemini.UserJdbc.entity.User;





	@Service
	@Transactional
	public class ServiceMain {

		@Autowired
		Dao dao;
		
		public User userRegistration(User user)
		{
			if(!dao.existsById(user.getUserId()))
			{
			User u=dao.save(user);
			return u;
			}
			else
			{
				return null;
			}
		}
		
		public User userLogin(String userId,String password)
		{
			
			if(dao.existsById(userId))
			{
				/*User u=dao.getOne(userId);
				if(u.getPassword()==password)
				{
				return u;
				}
				else
				{
					return null;
				}*/
				
				return dao.getOne(userId);
			}
			else
			{
			return null;
			}
			//return dao.userLogin(userId, password);
		}
		
		
		public int passwordRecovery(String userId,String password,String rePassword)
		{
			if(dao.existsById(userId))
			{
			return dao.update(userId, password, rePassword);	
			}
			else
			{
				return 0;
			}
			
			
		}
		public String userLogout(String userId)
		{
			return null;
		}
	}


