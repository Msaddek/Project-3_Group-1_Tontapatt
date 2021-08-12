package fr.eql.ai109.business;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.RatingIBusiness;
import fr.eql.ai109.tontapatt.entity.Rating;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.User;
import fr.eql.ai109.tontapatt.idao.RatingIDAO;

@Remote(RatingIBusiness.class)
@Stateless
public class RatingBusiness implements RatingIBusiness {

	@EJB
	private RatingIDAO ratingIDAO;

	@Override
	public Rating add(Rating t) {
		// TODO Auto-generated method stub
		return null;
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
	public Set<Rating> getAllBySearingOffer(ShearingOffer selectedOffer, User connectedUser) {
		return ratingIDAO.getAllBySearingOffer(selectedOffer, connectedUser);
	}
}
