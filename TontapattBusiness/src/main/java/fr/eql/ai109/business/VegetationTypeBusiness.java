package fr.eql.ai109.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.VegetationTypeIBusiness;
import fr.eql.ai109.tontapatt.entity.VegetationType;
import fr.eql.ai109.tontapatt.idao.VegetationTypeIDAO;

@Remote(VegetationTypeIBusiness.class)
@Stateless
public class VegetationTypeBusiness implements VegetationTypeIBusiness {

	@EJB
	private VegetationTypeIDAO vegetationTypeIDAO;

	@Override
	public VegetationType add(VegetationType t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(VegetationType t) {
		// TODO Auto-generated method stub

	}

	@Override
	public VegetationType update(VegetationType t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VegetationType getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VegetationType> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
