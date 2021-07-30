package fr.eql.ai109.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.SpeciesIBusiness;
import fr.eql.ai109.tontapatt.idao.SpeciesIDAO;


@Remote(SpeciesIBusiness.class)
@Stateless
public class SpeciesBusiness implements SpeciesIBusiness{

	
	@EJB
	private SpeciesIDAO speciesIDAO;
}
