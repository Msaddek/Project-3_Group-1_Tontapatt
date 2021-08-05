package fr.eql.ai109.business;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.UserCategoryIBusiness;
import fr.eql.ai109.ibusiness.VegetationCompositionIBusiness;
import fr.eql.ai109.tontapatt.entity.VegetationComposition;
import fr.eql.ai109.tontapatt.idao.VegetationCompositionIDAO;

@Remote(VegetationCompositionIBusiness.class)
@Stateless
public class VegetationCompositionBusiness implements VegetationCompositionIBusiness {

	@EJB
	VegetationCompositionIDAO vegetationCompositionIDAO;
	
	
	@Override
	public VegetationComposition add(VegetationComposition t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(VegetationComposition t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VegetationComposition update(VegetationComposition t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VegetationComposition getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VegetationComposition> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
