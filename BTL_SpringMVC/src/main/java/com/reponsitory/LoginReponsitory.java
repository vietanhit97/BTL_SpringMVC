package com.reponsitory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Account;
import com.model.Category;

@Repository
public class LoginReponsitory {
	@Autowired
	private SessionFactory sessionFactory;

	public Account getAccount(String name, String password) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Account account = (Account) session.createCriteria(Account.class).add(Restrictions.eq("name", name))
					.add(Restrictions.eq("password", password)).uniqueResult();
			return account;
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
