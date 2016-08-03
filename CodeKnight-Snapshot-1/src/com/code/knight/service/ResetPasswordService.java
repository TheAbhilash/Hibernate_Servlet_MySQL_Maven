package com.code.knight.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.code.knight.dto.User;
import com.code.knight.util.HibernateUtil;

public class ResetPasswordService {

	public boolean isUserExists(User user1) {
		Session session = HibernateUtil.openSession();
		boolean result = false;
		Transaction tx = null;
		try{
			tx = session.getTransaction();
			tx.begin();
			User u = (User) session.get(User.class, user1.getId());
			tx.commit();
			if(u!=null) result = true;
		}catch(Exception ex){
			if(tx!=null){
				tx.rollback();
			}
		}finally {
			session.close();
		}
		return result;
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
}
