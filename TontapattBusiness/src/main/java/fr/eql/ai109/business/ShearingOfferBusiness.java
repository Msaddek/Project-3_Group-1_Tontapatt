package fr.eql.ai109.business;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.ShearingOfferIBusiness;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.User;
import fr.eql.ai109.tontapatt.idao.ShearingOfferIDAO;

@Remote(ShearingOfferIBusiness.class)
@Stateless
public class ShearingOfferBusiness implements ShearingOfferIBusiness {

	@EJB
	private ShearingOfferIDAO shearingOfferIDAO;

	@Override
	public ShearingOffer add(ShearingOffer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ShearingOffer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ShearingOffer update(ShearingOffer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShearingOffer getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShearingOffer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ShearingOffer> findShearingOffersByUser(User connectedUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
