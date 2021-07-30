package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.idao.FieldIDAO;

@Remote(FieldIDAO.class)
@Stateless
public class FieldDAO extends GenericDAO<Field>
		implements FieldIDAO {

}
