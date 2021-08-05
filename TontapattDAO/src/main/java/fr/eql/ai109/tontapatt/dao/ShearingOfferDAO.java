package fr.eql.ai109.tontapatt.dao;

import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;

import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.ShearingOfferPhoto;
import fr.eql.ai109.tontapatt.entity.User;
import fr.eql.ai109.tontapatt.idao.ShearingOfferIDAO;

@Remote(ShearingOfferIDAO.class)
@Stateless
public class ShearingOfferDAO extends GenericDAO<ShearingOffer>
		implements ShearingOfferIDAO {
	
	@Override
	public Set<ShearingOffer> findShearingOffersByUser(User user) {
		Set<ShearingOffer> offers = null;
		Query query = em.createQuery("SELECT so FROM ShearingOffer so WHERE so.breeder=:breederParam ");
		query.setParameter("breederParam", user);
		offers = (Set<ShearingOffer>) query.getResultList();
		return offers;
	}
}
