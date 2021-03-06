package com.springDemo.LoginExample.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springDemo.LoginExample.Model.User;

class UserMapper implements RowMapper<User> {

public User mapRow(ResultSet rs, int arg1) throws SQLException {

  User user = new User();
  user.setUsername(rs.getString("username"));
  user.setPassword(rs.getString("password"));
  user.setFirstname(rs.getString("firstname"));
  user.setLastname(rs.getString("lastname"));
  user.setEmail(rs.getString("email"));
  user.setAddress(rs.getString("address"));
  user.setPhoneNumber(rs.getInt("phoneNumber"));

  return user;

}

}