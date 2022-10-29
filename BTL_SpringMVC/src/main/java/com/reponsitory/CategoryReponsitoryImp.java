package com.reponsitory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Category;

@Repository
public class CategoryReponsitoryImp implements DaoReponsitory<Category, Integer> {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> getListPaginate(Integer page) {
		int max = 4;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			List<Category> data = session.createCriteria(Category.class).setMaxResults(max).setFirstResult((page-1)*max).list();
			session.close();
			return data;
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			session.close();
		}
		return null;
	}

	@Override
	public List<Category> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getById(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean add(Category t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean edit(Category t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean remove(Category t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long Count() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Long count = (Long) session.createCriteria(Category.class).setProjection(Projections.rowCount()).uniqueResult();
			return count;
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
