package fr.eql.ai109.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.UserIBusiness;
import fr.eql.ai109.tontapatt.entity.User;
import fr.eql.ai109.tontapatt.idao.UserIDAO;

@Remote(UserIBusiness.class)
@Stateless
public class UserBusiness implements UserIBusiness {

	@EJB
	private UserIDAO userIDAO;

	@Override
	public User add(User t) {
		return userIDAO.add(t);
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub

	}

	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User connection(String email, String password) {
		return userIDAO.authenticate(email, password);
	}

}

	@Override
	public Boolean verifyIfUserExists(String email) {
		return userIDAO.verifyIfUserExists(email);
	}

}
