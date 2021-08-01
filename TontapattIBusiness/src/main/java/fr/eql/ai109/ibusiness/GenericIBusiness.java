package fr.eql.ai109.ibusiness;

import java.util.List;

public interface GenericIBusiness<T> {
	
	T add(T t);
	void delete(T t);
	T update(T t);
	T getById(int i);
	List<T> getAll();

}
