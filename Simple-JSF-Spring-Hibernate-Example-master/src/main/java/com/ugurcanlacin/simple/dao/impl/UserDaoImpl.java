package com.ugurcanlacin.simple.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ugurcanlacin.simple.dao.UserDao;
import com.ugurcanlacin.simple.model.User;

import java.util.List;
import org.hibernate.Session;
//import org.hibernate.query.Query;


import com.ugurcanlacin.simple.util.HibernateUtil;



@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveUser(User user) {
		//sessionFactory.getCurrentSession().persist(user);
        sessionFactory.getCurrentSession().save(user);
	}

	public User findUserById(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		
	}

	public void deleteUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

    @Override
    @SuppressWarnings("unchecked")
    public List<User> userList()
    {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from User");
        List<User> userList = query.list();

        return userList;
    }

    public User getByUserPass(String username, String pass){
        Session session = sessionFactory.getCurrentSession();
        //Funciona con Int
        // User user = (User)session.get(User.class, new Integer(9));
        //Query query = session.createQuery("FROM User AS U WHERE U.name like '" + username + "%'");

        //Query query = session.createQuery("FROM User AS U WHERE U.name  = \'" +username + "\'");

        Query query = session.createQuery("FROM User AS U WHERE U.name  = \'" +username + "\' and U.surname = \'"+ pass + "\'");

        User user = (User)query.uniqueResult();

        return user;
    }





}
