package com.reponsitory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.Product;

@Repository
public class ProductReponsitoryImp implements DaoReponsitory<Product, Integer> {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getListPaginate(Integer page) {
		int max = 4;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			List<Product> data = session.createCriteria(Product.class).setMaxResults(max)
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
	public List<Product> getByName(String name) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<Product> data = session.createCriteria(Product.class).add(Restrictions.like("name", "%" + name + "%"))
					.list();
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
	public Long Count() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Long count = (Long) session.createCriteria(Product.class).setProjection(Projections.rowCount())
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
	public Product getById(Integer Id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Product c = (Product) session.get(Product.class, Id);
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
	public boolean add(Product t) {
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
	public boolean edit(Product t) {
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
