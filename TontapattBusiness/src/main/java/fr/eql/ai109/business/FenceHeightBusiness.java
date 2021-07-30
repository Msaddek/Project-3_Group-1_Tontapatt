package fr.eql.ai109.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.FenceHeightIBusiness;
import fr.eql.ai109.tontapatt.entity.FenceHeight;
import fr.eql.ai109.tontapatt.idao.FenceHeightIDAO;

@Remote(FenceHeightIBusiness.class)
@Stateless
public class FenceHeightBusiness extends GenericBusiness<FenceHeight>
		implements FenceHeightIBusiness {

	@EJB
	private FenceHeightIDAO fenceHeightIDAO;
}
