package com.code.knight.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.code.knight.dto.User;
import com.code.knight.util.HibernateUtil;

public class LoginService {

	public boolean authencateUser(String userName, String password){
		User user = getUserByUserId(userName);
		if(user!=null && user.getUserName().equals(userName) && user.getPassword().equals(password)){
			return true;
		}else{
			return false;
		}
	}

	public User getUserByUserId(String userName) {
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		User user = null;
		
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from User where userName='"+userName+"'");
			user = (User) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
	}
	
	public List<User> getListOfUsers(){
		List<User> list = new ArrayList<User>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from User");
			list = query.list();
			tx.commit();
		} catch (Exception e) {
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
}
