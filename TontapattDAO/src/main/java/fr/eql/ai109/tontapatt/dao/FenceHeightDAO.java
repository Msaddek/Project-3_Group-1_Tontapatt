package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.FenceHeight;
import fr.eql.ai109.tontapatt.idao.FenceHeightIDAO;

@Remote(FenceHeightIDAO.class)
@Stateless
public class FenceHeightDAO extends GenericDAO<FenceHeight>
		implements FenceHeightIDAO {

}
