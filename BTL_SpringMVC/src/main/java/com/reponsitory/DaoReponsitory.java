package com.reponsitory;

import java.util.List;

import com.model.Orders;

public interface DaoReponsitory<T, Id> {
	List<T> getListPaginate(Integer page);

	List<T> getList();

	List<T> getByName(String name, int page);

	Long count();
	Long countImport();
	Long countExport();
	Long countSearch(String key);

	T getById(Integer Id);

	boolean add(T t);

	boolean edit(T t);

	public Boolean delete(Integer id);

	List<Orders> getListPaginateEmport(Integer page);
}
