package fr.eql.ai109.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.FlatnessPercentageIBusiness;
import fr.eql.ai109.tontapatt.idao.FlatnessPercentageIDAO;



@Remote(FlatnessPercentageIBusiness.class)
@Stateless
public class FlatnessPercentageBusiness implements FlatnessPercentageIBusiness{

	@EJB
	private FlatnessPercentageIDAO flatnessPercentageIDAO;
}
