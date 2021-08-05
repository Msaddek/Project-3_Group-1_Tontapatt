package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.VegetationComposition;
import fr.eql.ai109.tontapatt.idao.VegetationCompositionIDAO;

@Remote(VegetationCompositionIDAO.class)
@Stateless
public class VegetationCompositionDAO extends GenericDAO<VegetationComposition> implements VegetationCompositionIDAO{

}
