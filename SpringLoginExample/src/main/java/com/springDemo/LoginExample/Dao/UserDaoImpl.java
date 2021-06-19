package com.springDemo.LoginExample.Dao;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.springDemo.LoginExample.Model.Login;
import com.springDemo.LoginExample.Model.User;

public class UserDaoImpl implements UserDao
{
	@Autowired
	DataSource dataSource;
	
	/*@Autowired 
	JdbcTemplate jdbcTemplate;*/
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void register(User user) 
	{
		Session session = null;
	    System.out.println(user.getFirstname()+" "+user.getLastname()+" "+user.getUsername()+" "+user.getPassword()+" "+user.getAddress()+" "+user.getEmail());
	    
	    /*jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
	    		user.getLastname(), user.getEmail(), user.getAddress(), user.getPhoneNumber() });
*/
	    try {
    session = sessionFactory.getCurrentSession();
    
   //session.beginTransaction();
   session.saveOrUpdate(user);
   session.getTransaction().commit();
	    }
   
   catch (RuntimeException e) {
	   session.getTransaction().rollback();
	    throw e;
	}
	}

	/*public User validateUser(Login login) {
	    String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
	    + "'";
	    List<User> users = jdbcTemplate.query(sql, new UserMapper());
	    return users.size() > 0 ? users.get(0) : null;
	    }
}
	
*/	
	
	public User validateUser(Login login)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(User.class);
	    criteria.add(Restrictions.eq("username", login.getUsername()));
	    criteria.add(Restrictions.eq("password", login.getPassword()));
	    
	    //session.getTransaction().commit();
	    User log=(User) criteria.uniqueResult();
	    
	    tx.commit();
	   //System.out.println(log.getFirstname()+" "+log.getUsername());
		return log;
		
	}
}
	/*public User validateUser(Login login) {
	
	    String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
	    + "'";			    
	    List<User> users = jdbcTemplate.query(sql, new UserMapper());
	 
	    return users.size() > 0 ? users.get(0) : null;

	}
*/
	
