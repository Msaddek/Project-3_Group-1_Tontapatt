package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.Race;
import fr.eql.ai109.tontapatt.idao.RaceIDAO;

@Remote(RaceIDAO.class)
@Stateless
public class RaceDAO extends GenericDAO<Race>
		implements RaceIDAO {

}
