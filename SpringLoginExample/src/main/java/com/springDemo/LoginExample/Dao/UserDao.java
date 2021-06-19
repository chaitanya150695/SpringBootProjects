package com.springDemo.LoginExample.Dao;

import com.springDemo.LoginExample.Model.Login;
import com.springDemo.LoginExample.Model.User;

public interface UserDao {

  void register(User user);

  User validateUser(Login login);

}