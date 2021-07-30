package fr.eql.ai109.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.VegetationTypeIBusiness;
import fr.eql.ai109.tontapatt.idao.VegetationTypeIDAO;



@Remote(VegetationTypeIBusiness.class)
@Stateless
public class VegetationTypeBusiness implements VegetationTypeIBusiness{

	
	@EJB
	private VegetationTypeIDAO vegetationTypeIDAO;
}
