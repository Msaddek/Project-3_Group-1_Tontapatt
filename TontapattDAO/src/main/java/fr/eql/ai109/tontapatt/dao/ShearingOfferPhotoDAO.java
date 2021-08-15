package fr.eql.ai109.tontapatt.dao;

import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;

import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.ShearingOfferPhoto;
import fr.eql.ai109.tontapatt.idao.ShearingOfferPhotoIDAO;

@Remote(ShearingOfferPhotoIDAO.class)
@Stateless
public class ShearingOfferPhotoDAO extends GenericDAO<ShearingOfferPhoto>
		implements ShearingOfferPhotoIDAO {

	@Override
	public Set<ShearingOfferPhoto> findPhotosByShearingOffer(ShearingOffer shearingOffer) {
		Set<ShearingOfferPhoto> photos = null;
		Query query = em.createQuery("SELECT sop FROM ShearingOfferPhoto sop WHERE sop.shearingOffer=:shearingOfferParam ");
		query.setParameter("shearingOfferParam", shearingOffer);
		photos = (Set<ShearingOfferPhoto>) query.getResultList();
		return photos;
	}
}
