package fr.eql.ai109.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.AnomalyTypeIBusiness;
import fr.eql.ai109.tontapatt.entity.AnomalyType;
import fr.eql.ai109.tontapatt.idao.AnomalyTypeIDAO;

@Remote(AnomalyTypeIBusiness.class)
@Stateless
public class AnomalyTypeBusiness implements AnomalyTypeIBusiness {

	@EJB
	private AnomalyTypeIDAO anomalyTypeIDAO;

	@Override
	public AnomalyType add(AnomalyType t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(AnomalyType t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AnomalyType update(AnomalyType t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnomalyType getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AnomalyType> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
