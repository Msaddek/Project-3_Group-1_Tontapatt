package fr.eql.ai109.tontapatt.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Query;
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

	@Override
	public Boolean exists(User user) {
		
		List<User> users = null;
		
		Query query = em.createQuery("SELECT u FROM User u WHERE u.login=:loginParam");
		query.setParameter("loginParam", user.getEmail());
		users = query.getResultList();
		
	return users.size() > 0;
	}

	@Override
	public User authenticate(String email, String password) {
		
		User user = null;
		List<User> users = null;
		
			Query query =  em.createQuery("SELECT u FROM User u WHERE u.email=:emailParam "
					+ "AND u.password=:passwordParam");
			query.setParameter("emailParam", email);
			query.setParameter("passwordParam", password);
			users = query.getResultList();
			
		if (users.size() > 0) {
			user = users.get(0);
		}
		return user;
		
	}


}
