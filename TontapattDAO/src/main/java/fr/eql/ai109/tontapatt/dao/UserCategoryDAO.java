package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.UserCategory;
import fr.eql.ai109.tontapatt.idao.UserCategoryIDAO;

@Remote(UserCategoryIDAO.class)
@Stateless
public class UserCategoryDAO extends GenericDAO<UserCategory>
		implements UserCategoryIDAO {

}
