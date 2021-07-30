package fr.eql.ai109.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.ShearingOfferIBusiness;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.idao.ShearingOfferIDAO;

@Remote(ShearingOfferIBusiness.class)
@Stateless
public class ShearingOfferBusiness extends GenericBusiness<ShearingOffer>
		implements ShearingOfferIBusiness {

	@EJB
	private ShearingOfferIDAO shearingOfferIDAO;

}
