package com.reponsitory;

import java.util.List;

public interface DaoReponsitory<T,Id> {
	List<T> getListPaginate(Integer page);
	List<T> getByName(String name);
	Long Count();
	T getById(Integer Id);
	Boolean add(T t);
	Boolean edit(T t);
	Boolean remove(T t);
}
