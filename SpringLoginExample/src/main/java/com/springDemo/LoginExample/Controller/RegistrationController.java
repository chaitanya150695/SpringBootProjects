package com.springDemo.LoginExample.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springDemo.LoginExample.Model.User;
import com.springDemo.LoginExample.Service.UserService;

@Controller
public class RegistrationController {

	  @Autowired
	  UserService userService;
	
	@RequestMapping(value="/register", method= RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest req, HttpServletResponse res)
	{
		ModelAndView mav = new ModelAndView("register");
		System.out.println("In  register process");
		mav.addObject("user",new User());
		return mav;
	}
	
	@RequestMapping(value = "/registerProcess",method = RequestMethod.POST)
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("user") User user) 
	  {
		ModelAndView m = new ModelAndView("welcome");
		System.out.println("hello in adduser");  
		System.out.println("In  register complete:"+user.getFirstname());
		userService.register(user);
	  m.addObject("Username", user.getFirstname());
	  return m;

	  }
}
