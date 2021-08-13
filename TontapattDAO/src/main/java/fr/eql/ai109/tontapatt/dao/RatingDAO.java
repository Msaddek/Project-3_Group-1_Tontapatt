package fr.eql.ai109.tontapatt.dao;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.Rating;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.User;
import fr.eql.ai109.tontapatt.idao.RatingIDAO;

@Remote(RatingIDAO.class)
@Stateless
public class RatingDAO extends GenericDAO<Rating> implements RatingIDAO {

	@Override
	public Set<Rating> getAllBySearingOffer(ShearingOffer selectedOffer,
			User connectedUser) {
		Set<Rating> ratings = null;
		String sqlQuery = "SELECT r FROM Rating r WHERE "
				+ "r.service.shearingOffer=:offerParam AND r.evaluator!=:userParam";
		try {
			ratings = new HashSet<>(em.createNamedQuery(sqlQuery)
					.setParameter("offerParam", selectedOffer)
					.setParameter("userParam", connectedUser).getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ratings;
	}

}
