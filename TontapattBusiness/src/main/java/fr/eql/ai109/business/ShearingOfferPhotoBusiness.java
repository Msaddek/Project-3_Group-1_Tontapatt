package fr.eql.ai109.business;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.ShearingOfferPhotoIBusiness;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.ShearingOfferPhoto;
import fr.eql.ai109.tontapatt.idao.ShearingOfferPhotoIDAO;

@Remote(ShearingOfferPhotoIBusiness.class)
@Stateless
public class ShearingOfferPhotoBusiness implements ShearingOfferPhotoIBusiness {

	@EJB
	private ShearingOfferPhotoIDAO shearingOfferPhotoIDAO;

	@Override
	public ShearingOfferPhoto add(ShearingOfferPhoto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ShearingOfferPhoto t) {
		// TODO Auto-generated method stub

	}

	@Override
	public ShearingOfferPhoto update(ShearingOfferPhoto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShearingOfferPhoto getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShearingOfferPhoto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ShearingOfferPhoto> findPhotosByShearingOffer(ShearingOffer shearingOffer) {
		// TODO Auto-generated method stub
		return null;
	}

}
