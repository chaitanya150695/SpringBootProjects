package com.springDemo.LoginExample.Service;

import com.springDemo.LoginExample.Model.Login;
import com.springDemo.LoginExample.Model.User;


public interface UserService {

	 void register(User user);

	 User validateUser(Login login);	
}
