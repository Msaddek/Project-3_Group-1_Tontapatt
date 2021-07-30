package fr.eql.ai109.business;


import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.RaceIBusiness;
import fr.eql.ai109.tontapatt.idao.RaceIDAO;


@Remote(RaceIBusiness.class)
@Stateless
public class RaceBusiness implements RaceIBusiness{

	
	@EJB
	private RaceIDAO raceIDAO;
}
