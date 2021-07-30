package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.GrassHeight;
import fr.eql.ai109.tontapatt.idao.GrassHeightIDAO;

@Remote(GrassHeightIDAO.class)
@Stateless
public class GrassHeightDAO extends GenericDAO<GrassHeight>
		implements GrassHeightIDAO {

}
