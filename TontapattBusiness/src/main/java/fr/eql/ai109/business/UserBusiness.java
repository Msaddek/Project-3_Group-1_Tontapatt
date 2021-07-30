package fr.eql.ai109.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.UserIBusiness;
import fr.eql.ai109.tontapatt.entity.User;
import fr.eql.ai109.tontapatt.idao.UserIDAO;

@Remote(UserIBusiness.class)
@Stateless
public class UserBusiness extends GenericBusiness<User>
		implements UserIBusiness {

	@EJB
	private UserIDAO userIDAO;

}
