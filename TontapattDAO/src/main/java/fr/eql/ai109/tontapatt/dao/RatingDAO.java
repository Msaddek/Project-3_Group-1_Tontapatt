package fr.eql.ai109.tontapatt.dao;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.Rating;
import fr.eql.ai109.tontapatt.entity.Service;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.idao.RatingIDAO;

@Remote(RatingIDAO.class)
@Stateless
public class RatingDAO extends GenericDAO<Rating> implements RatingIDAO {

	@Override
	public Set<Rating> getAllByShearingOffer(ShearingOffer selectedOffer) {
		Set<Rating> ratings = null;
		String sqlQuery = "SELECT r FROM Rating r WHERE "
				+ "r.service.shearingOffer=:offerParam AND r.evaluator!=:userParam";
		try {
			ratings = new HashSet<>(em.createQuery(sqlQuery)
					.setParameter("offerParam", selectedOffer)
					.setParameter("userParam", selectedOffer.getBreeder())
					.getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ratings;
	}

	@Override
	public Set<Rating> getAllByField(Field selectedField) {
		Set<Rating> ratings = null;
		String sqlQuery = "SELECT r FROM Rating r WHERE "
				+ "r.service.field=:fieldParam AND r.evaluator!=:userParam";
		try {
			ratings = new HashSet<>(em.createQuery(sqlQuery)
					.setParameter("fieldParam", selectedField)
					.setParameter("userParam", selectedField.getOwner())
					.getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ratings;
	}

	@Override
	public Set<Rating> getAllbyService(Service selectedService) {
		Set<Rating> ratings = null;
		String sqlQuery = "SELECT r FROM Rating r WHERE "
				+ "r.service=:serviceParam";
		try {
			ratings = new HashSet<>(em.createQuery(sqlQuery)
					.setParameter("serviceParam", selectedService)
					.getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ratings;
	}

}
