package fr.eql.ai109.business;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
<<<<<<< HEAD

import fr.eql.ai109.ibusiness.UserCategoryIBusiness;
=======
>>>>>>> 4d49b48242dc24142d284104ec7b8cc6d73c2738
import fr.eql.ai109.ibusiness.VegetationCompositionIBusiness;
import fr.eql.ai109.tontapatt.entity.VegetationComposition;
import fr.eql.ai109.tontapatt.idao.VegetationCompositionIDAO;

<<<<<<< HEAD
=======

>>>>>>> 4d49b48242dc24142d284104ec7b8cc6d73c2738
@Remote(VegetationCompositionIBusiness.class)
@Stateless
public class VegetationCompositionBusiness implements VegetationCompositionIBusiness {

	@EJB
	private VegetationCompositionIDAO vegetationCompositionIDAO;
	
	
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
