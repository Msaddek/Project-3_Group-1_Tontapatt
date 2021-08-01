package fr.eql.ai109.tontapatt.idao;

import fr.eql.ai109.tontapatt.entity.User;

public interface UserIDAO extends GenericIDAO<User> {
	
	Boolean exists(User user);
	User authenticate(String login, String password);
	
}
