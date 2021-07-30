package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.User;
import fr.eql.ai109.tontapatt.idao.UserIDAO;

@Remote(UserIDAO.class)
@Stateless
public class UserDAO extends GenericDAO<User>
		implements UserIDAO {

}
