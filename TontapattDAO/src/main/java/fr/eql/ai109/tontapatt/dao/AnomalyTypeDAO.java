package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.AnomalyType;
import fr.eql.ai109.tontapatt.idao.AnomalyTypeIDAO;

@Remote(AnomalyTypeIDAO.class)
@Stateless
public class AnomalyTypeDAO extends GenericDAO<AnomalyType>
		implements AnomalyTypeIDAO {

}
