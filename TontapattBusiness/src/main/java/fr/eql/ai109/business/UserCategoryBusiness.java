package fr.eql.ai109.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.UserCategoryIBusiness;
import fr.eql.ai109.tontapatt.entity.UserCategory;
import fr.eql.ai109.tontapatt.idao.UserCategoryIDAO;

@Remote(UserCategoryIBusiness.class)
@Stateless
public class UserCategoryBusiness implements UserCategoryIBusiness {

	@EJB
	private UserCategoryIDAO userCategoryIDAO;

	@Override
	public UserCategory add(UserCategory t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UserCategory t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserCategory update(UserCategory t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserCategory getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserCategory> getAll() {
		return userCategoryIDAO.getAll();
	}
}
