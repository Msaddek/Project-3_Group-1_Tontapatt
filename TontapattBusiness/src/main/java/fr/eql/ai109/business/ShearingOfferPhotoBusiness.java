package fr.eql.ai109.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.ShearingOfferPhotoIBusiness;
import fr.eql.ai109.tontapatt.entity.ShearingOfferPhoto;
import fr.eql.ai109.tontapatt.idao.ShearingOfferPhotoIDAO;

@Remote(ShearingOfferPhotoIBusiness.class)
@Stateless
public class ShearingOfferPhotoBusiness
		extends GenericBusiness<ShearingOfferPhoto>
		implements ShearingOfferPhotoIBusiness {

	@EJB
	private ShearingOfferPhotoIDAO shearingOfferPhotoIDAO;

}
