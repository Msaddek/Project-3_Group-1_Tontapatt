package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.VegetationType;
import fr.eql.ai109.tontapatt.idao.VegetationTypeIDAO;

@Remote(VegetationTypeIDAO.class)
@Stateless
public class VegetationTypeDAO extends GenericDAO<VegetationType>
		implements VegetationTypeIDAO {

}
