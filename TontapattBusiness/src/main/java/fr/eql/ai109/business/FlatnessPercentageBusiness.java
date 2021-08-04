package fr.eql.ai109.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.FlatnessPercentageIBusiness;
import fr.eql.ai109.tontapatt.entity.FlatnessPercentage;
import fr.eql.ai109.tontapatt.idao.FlatnessPercentageIDAO;

@Remote(FlatnessPercentageIBusiness.class)
@Stateless
public class FlatnessPercentageBusiness
		implements FlatnessPercentageIBusiness {

	@EJB
	private FlatnessPercentageIDAO flatnessPercentageIDAO;

	@Override
	public FlatnessPercentage add(FlatnessPercentage t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(FlatnessPercentage t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FlatnessPercentage update(FlatnessPercentage t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FlatnessPercentage getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlatnessPercentage> getAll() {
		return flatnessPercentageIDAO.getAll();
	}
}
