package fr.eql.ai109.business;

import java.util.List;

import javax.ejb.EJB;

import fr.eql.ai109.ibusiness.GenericIBusiness;
import fr.eql.ai109.tontapatt.idao.GenericIDAO;

public class GenericBusiness<T> implements GenericIBusiness<T> {

	@EJB
	private GenericIDAO<T> genericIDAO;
	
	@Override
	public T add(T t) {
		return genericIDAO.add(t);
	}

	@Override
	public void delete(T t) {
		genericIDAO.delete(t);
		
	}

	@Override
	public T update(T t) {
		return genericIDAO.update(t);
	}

	@Override
	public T getById(int i) {
		return genericIDAO.getById(i);
	}

	@Override
	public List<T> getAll() {
		return genericIDAO.getAll();
	}

}
