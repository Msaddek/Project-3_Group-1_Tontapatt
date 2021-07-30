package fr.eql.ai109.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.UserCategoryIBusiness;
import fr.eql.ai109.tontapatt.entity.UserCategory;
import fr.eql.ai109.tontapatt.idao.UserCategoryIDAO;

@Remote(UserCategoryIBusiness.class)
@Stateless
public class UserCategoryBusiness extends GenericBusiness<UserCategory>
		implements UserCategoryIBusiness {

	@EJB
	private UserCategoryIDAO userCategoryIDAO;
}
