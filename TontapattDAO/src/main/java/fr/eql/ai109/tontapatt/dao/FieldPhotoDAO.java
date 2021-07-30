package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.FieldPhoto;
import fr.eql.ai109.tontapatt.idao.FieldPhotoIDAO;

@Remote(FieldPhotoIDAO.class)
@Stateless
public class FieldPhotoDAO extends GenericDAO<FieldPhoto>
		implements FieldPhotoIDAO {

}
