package fr.eql.ai109.tontapatt.idao;

import fr.eql.ai109.tontapatt.entity.User;

public interface UserIDAO extends GenericIDAO<User> {

	Boolean verifyIfUserExists(String email);

	Boolean exists(User user);

	User authenticate(String login, String password);
	
	Boolean verifyDuplicateEmailOnUpdate(Integer id, String email);

}
