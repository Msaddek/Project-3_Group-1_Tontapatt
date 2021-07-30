package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.Anomaly;
import fr.eql.ai109.tontapatt.idao.AnomalyIDAO;

@Remote(AnomalyIDAO.class)
@Stateless
public class AnomalyDAO extends GenericDAO<Anomaly>
		implements AnomalyIDAO {

}
