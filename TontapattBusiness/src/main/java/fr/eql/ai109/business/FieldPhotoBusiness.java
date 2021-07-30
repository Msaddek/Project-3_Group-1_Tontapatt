package fr.eql.ai109.business;


import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;


import fr.eql.ai109.ibusiness.FieldPhotoIBusiness;
import fr.eql.ai109.tontapatt.idao.FieldPhotoIDAO;



@Remote(FieldPhotoIBusiness.class)
@Stateless
public class FieldPhotoBusiness implements FieldPhotoIBusiness{

	@EJB
	private FieldPhotoIDAO fieldPhotoIDAO;
}
