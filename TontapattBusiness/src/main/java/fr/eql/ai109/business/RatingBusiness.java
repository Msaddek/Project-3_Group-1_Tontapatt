package fr.eql.ai109.business;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.RatingIBusiness;
import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.Rating;
import fr.eql.ai109.tontapatt.entity.Service;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.idao.RatingIDAO;

@Remote(RatingIBusiness.class)
@Stateless
public class RatingBusiness implements RatingIBusiness {

	@EJB
	private RatingIDAO ratingIDAO;

	@Override
	public Rating add(Rating t) {
		return ratingIDAO.add(t);
	}

	@Override
	public void delete(Rating t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rating update(Rating t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rating getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rating> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Rating> getAllByShearingOffer(ShearingOffer selectedOffer) {
		return ratingIDAO.getAllByShearingOffer(selectedOffer);
	}

	@Override
	public Set<Rating> getAllByField(Field selectedField) {
		return ratingIDAO.getAllByField(selectedField);
	}

	@Override
	public Set<Rating> getAllbyService(Service selectedService) {
		return ratingIDAO.getAllbyService(selectedService);
	}
}
