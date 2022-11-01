package com.reponsitory;

import java.util.List;

public interface DaoReponsitory<T,Id> {
	List<T> getListPaginate(Integer page);
	List<T> getList();
	List<T> getByName(String name,int page);
	Long count();
	Long countSearch(String key);
	T getById(Integer Id);
	boolean add(T t);
	boolean edit(T t);
	boolean remove(Integer id);
}
