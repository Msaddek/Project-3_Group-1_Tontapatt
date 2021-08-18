package fr.eql.ai109.tontapatt.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.eql.ai109.tontapatt.idao.GenericIDAO;

public abstract class GenericDAO<T> implements GenericIDAO<T> {

	@PersistenceContext(unitName = "Persistence")
	protected EntityManager em;

	public T add(T t) {
		try {
			em.persist(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	public void delete(T t) {
		try {
			em.remove(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public T update(T t) {
		try {
			em.merge(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	public T getById(int i) {
		T t = null;
		try {
			String className = ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0]
							.getTypeName();
			Class<?> clazz;
			clazz = Class.forName(className);
			t = (T) em.find(clazz, i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		List<T> objects = null;
		try {
			String className = ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0]
							.getTypeName();
			Class<?> clazz;
			clazz = Class.forName(className);

			objects = (List<T>) em.createQuery("FROM " + clazz.getName())
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
}
