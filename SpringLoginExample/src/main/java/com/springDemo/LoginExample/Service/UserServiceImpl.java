package com.springDemo.LoginExample.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import com.springDemo.LoginExample.Dao.UserDao;
import com.springDemo.LoginExample.Model.Login;
import com.springDemo.LoginExample.Model.User;

@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	public void register(User user) 
	{
		System.out.println("hello in register service");
		userDao.register(user);
		
	}
	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}

}
