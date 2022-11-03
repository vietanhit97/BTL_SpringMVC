package com.reponsitory;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.Orders;

@Repository
public class OrderReponsitoryImp implements DaoReponsitory<Orders, Integer>{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Orders> getListPaginate(Integer page) {
		int max = 4;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			List<Orders> data = session.createCriteria(Orders.class).add(Restrictions.eq("role", 1)).setMaxResults(max)
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
	public List<Orders> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> getByName(String name, int page) {
		int max = 4;
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<Orders> data = session.createCriteria(Orders.class).add(Restrictions.ilike("name", "%" + name + "%"))
					.setMaxResults(max).setFirstResult((page - 1) * max).list();
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
	public Long count() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Long count = (Long) session.createCriteria(Orders.class).setProjection(Projections.rowCount())
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
	public Long countSearch(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders getById(Integer Id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Orders o = (Orders) session.get(Orders.class, Id);
			session.getTransaction().commit();
			return o;
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
	public boolean add(Orders t) {
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
	public boolean edit(Orders t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean delete(Integer id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Orders o = session.load(Orders.class, id);
			session.remove(o);
			session.getTransaction().commit();	
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			session.getTransaction().rollback();	
		} finally {
			session.close();
		}
		return false;
	}

}
