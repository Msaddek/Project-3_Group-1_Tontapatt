package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.FlatnessPercentage;
import fr.eql.ai109.tontapatt.idao.FlatnessPercentageIDAO;

@Remote(FlatnessPercentageIDAO.class)
@Stateless
public class FlatnessPercentageDAO extends GenericDAO<FlatnessPercentage>
		implements FlatnessPercentageIDAO {

}
