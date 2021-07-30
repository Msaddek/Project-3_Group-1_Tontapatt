package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.ShearingOfferPhoto;
import fr.eql.ai109.tontapatt.idao.ShearingOfferPhotoIDAO;

@Remote(ShearingOfferPhotoIDAO.class)
@Stateless
public class ShearingOfferPhotoDAO extends GenericDAO<ShearingOfferPhoto>
		implements ShearingOfferPhotoIDAO {

}
