package fr.eql.ai109.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.RatingIBusiness;
import fr.eql.ai109.tontapatt.entity.Rating;
import fr.eql.ai109.tontapatt.idao.RatingIDAO;

@Remote(RatingIBusiness.class)
@Stateless
public class RatingBusiness extends GenericBusiness<Rating>
		implements RatingIBusiness {

	@EJB
	private RatingIDAO ratingIDAO;
}
