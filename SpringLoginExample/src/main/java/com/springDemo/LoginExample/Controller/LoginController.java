package com.springDemo.LoginExample.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springDemo.LoginExample.Dao.UserDaoImpl;
import com.springDemo.LoginExample.Model.Login;
import com.springDemo.LoginExample.Model.User;
import com.springDemo.LoginExample.Service.UserService;

@Controller
public class LoginController {

	  @Autowired
	  UserService userService;
	
		@RequestMapping(value="/login", method =  RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest req,HttpServletResponse res)
	{
		ModelAndView mav = new ModelAndView("login");
		System.out.println("In login");
		mav.addObject("login", new Login());
		return mav;
	}
		
		@RequestMapping(value="/test", method =  RequestMethod.GET)
		public ModelAndView test(HttpServletRequest req,HttpServletResponse res)
		{
			ModelAndView mav = new ModelAndView("test");
			System.out.println("In test");
			//mav.addObject("login", new Login());
			return mav;
		}
	
	@RequestMapping(value="/loginProcess",method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest req,HttpServletResponse res, 
			@ModelAttribute("login")Login login)
	{
		ModelAndView mav = null;
		
		User user = userService.validateUser(login);
		
		if(user!=null)
		{
			System.out.println(user.getUsername());
			mav = new ModelAndView("welcome");
			
			System.out.println(user.getFirstname());
		    mav.addObject("firstname", user.getFirstname());
		    } 
		else {
		    	mav = new ModelAndView("login");
		    	mav.addObject("message", "Username or Password is wrong!!");
		    }
		    return mav;
		}
	}
