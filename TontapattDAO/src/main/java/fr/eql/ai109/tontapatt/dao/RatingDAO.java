package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.Rating;
import fr.eql.ai109.tontapatt.idao.RatingIDAO;

@Remote(RatingIDAO.class)
@Stateless
public class RatingDAO extends GenericDAO<Rating> implements RatingIDAO {

}
