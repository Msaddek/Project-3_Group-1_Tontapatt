package fr.eql.ai109.tontapatt.dao;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.User;
import fr.eql.ai109.tontapatt.idao.FieldIDAO;

@Remote(FieldIDAO.class)
@Stateless
public class FieldDAO extends GenericDAO<Field> implements FieldIDAO {

	@Override
	public Set<Field> getFieldsOfConnectedUser(User user) {
		Set<Field> fields = null;
		try {
			fields = new HashSet<>(em.createQuery(
					"SELECT f from Field f WHERE f.owner=:ownerParam AND f.withdrawalDate IS NULL")
					.setParameter("ownerParam", user).getResultList());
			for (Field field : fields) {
				field.setVegetationCompositions(new HashSet<>(em.createQuery(
						"SELECT vc FROM VegetationComposition vc WHERE vc.field=:fieldParam")
						.setParameter("fieldParam", field).getResultList()));
				field.setPhotos(new HashSet<>(em.createQuery(
						"SELECT fp FROM FieldPhoto fp WHERE fp.field=:fieldParam")
						.setParameter("fieldParam", field).getResultList()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fields;
	}

	@Override
	public Set<Field> getAllWithPhotos() {
		Set<Field> fields = null;
		try {
			fields = new HashSet<>(em.createQuery(
					"SELECT f from Field f").getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fields;
	}

}
