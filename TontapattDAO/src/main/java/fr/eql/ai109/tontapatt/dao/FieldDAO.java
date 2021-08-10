package fr.eql.ai109.tontapatt.dao;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.FieldPhoto;
import fr.eql.ai109.tontapatt.entity.User;
import fr.eql.ai109.tontapatt.idao.FieldIDAO;

@Remote(FieldIDAO.class)
@Stateless
public class FieldDAO extends GenericDAO<Field> implements FieldIDAO {

	@Override
	public Set<Field> findFieldsByUser(User user) {
		Set<Field> fields = null;
		try {
			fields = new HashSet<Field>(em.createQuery("SELECT f from Field f WHERE f.owner=:ownerParam")
					.setParameter("ownerParam", user).getResultList());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return fields;
	}

}
