package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.idao.ShearingOfferIDAO;

@Remote(ShearingOfferIDAO.class)
@Stateless
public class ShearingOfferDAO extends GenericDAO<ShearingOffer>
		implements ShearingOfferIDAO {

}
