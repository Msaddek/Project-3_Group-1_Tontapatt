package fr.eql.ai109.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.GrassHeightIBusiness;
import fr.eql.ai109.tontapatt.entity.GrassHeight;
import fr.eql.ai109.tontapatt.idao.GrassHeightIDAO;

@Remote(GrassHeightIBusiness.class)
@Stateless
public class GrassHeightBusiness extends GenericBusiness<GrassHeight>
		implements GrassHeightIBusiness {

	@EJB
	private GrassHeightIDAO grassHeightIDAO;
}
