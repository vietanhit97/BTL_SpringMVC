package com.reponsitory;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
			List<Category> data = session.createCriteria(Category.class).setMaxResults(max)
					.setFirstResult((page - 1) * max).list();
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
	public List<Category> getByName(String name, int page) {
		// TODO Auto-generated method stub
		int max = 4;
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<Category> data = session.createCriteria(Category.class)
					.add(Restrictions.like("name", "%" + name + "%")).setMaxResults(max)
					.setFirstResult((page - 1) * max).list();
			return data;
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Category getById(Integer Id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Category c = (Category) session.get(Category.class, Id);
			session.getTransaction().commit();
			return c;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean add(Category t) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(t);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean edit(Category t) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(t);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean remove(Integer id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Category category = (Category) session.get(Category.class, id);
			session.remove(category);
			session.beginTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			session.getTransaction().rollback();
		}
		return false;
	}

	@Override
	public Long count() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Long count = (Long) session.createCriteria(Category.class).setProjection(Projections.rowCount())
					.uniqueResult();
			return count;
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Category> getList() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			List<Category> data = session.createCriteria(Category.class).list();
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
	public Long countSearch(String key) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Long count = (Long) session.createCriteria(Category.class).setProjection(Projections.rowCount())
					.add(Restrictions.like("name", "%" + key + "%")).uniqueResult();
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
