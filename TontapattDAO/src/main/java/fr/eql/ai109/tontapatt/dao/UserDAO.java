package fr.eql.ai109.tontapatt.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.User;
import fr.eql.ai109.tontapatt.idao.UserIDAO;

@Remote(UserIDAO.class)
@Stateless
public class UserDAO extends GenericDAO<User> implements UserIDAO {

	@SuppressWarnings("unchecked")
	@Override
	public Boolean verifyIfUserExists(String email) {
		List<User> users = null;

		try {
			users = (List<User>) em.createQuery("SELECT u From User u WHERE u.email=:emailParam")
					.setParameter("emailParam", email).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return users.size() > 0;
	}

}
