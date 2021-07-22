package fr.eql.ai109.tontapatt.idao;

import java.util.List;

public interface GenericIDAO<T> {
	
	T add(T t);
	void delete(T t);
	T update(T t);
	T getById(int i);
	List<T> getAll();
}
