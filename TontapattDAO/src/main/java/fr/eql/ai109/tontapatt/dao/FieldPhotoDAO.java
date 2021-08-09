package fr.eql.ai109.tontapatt.dao;

import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.FieldPhoto;
import fr.eql.ai109.tontapatt.idao.FieldPhotoIDAO;

@Remote(FieldPhotoIDAO.class)
@Stateless
public class FieldPhotoDAO extends GenericDAO<FieldPhoto> implements FieldPhotoIDAO {

	@Override
	public Set<FieldPhoto> findPhotosByField(Field field) {
		Set<FieldPhoto> fieldPhotos = null;
		try {
			fieldPhotos = (Set<FieldPhoto>) em.createQuery("SELECT fp from FieldPhoto fp WHERE fp.field=:fieldParam")
					.setParameter("fieldParam", field).getResultList();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return fieldPhotos;
	}

}
