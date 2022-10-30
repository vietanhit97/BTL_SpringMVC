package com.reponsitory;

import java.util.List;

public interface DaoReponsitory<T,Id> {
	List<T> getListPaginate(Integer page);
	List<T> getByName(String name);
	Long Count();
	T getById(Integer Id);
	boolean add(T t);
	boolean edit(T t);
	boolean remove(Integer id);
}
