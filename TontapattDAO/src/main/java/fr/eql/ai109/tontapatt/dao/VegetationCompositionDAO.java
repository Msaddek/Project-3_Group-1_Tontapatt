package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.VegetationComposition;
import fr.eql.ai109.tontapatt.idao.VegetationCompositionIDAO;

@Remote(VegetationCompositionIDAO.class)
@Stateless
<<<<<<< HEAD
public class VegetationCompositionDAO extends GenericDAO<VegetationComposition> implements VegetationCompositionIDAO{
=======
public class VegetationCompositionDAO extends GenericDAO<VegetationComposition>
		implements VegetationCompositionIDAO {
>>>>>>> 093262f0038feaa646c3f346124fe8bc77fec81e

}
