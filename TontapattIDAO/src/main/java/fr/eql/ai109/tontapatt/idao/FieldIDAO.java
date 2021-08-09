package fr.eql.ai109.tontapatt.idao;

import java.util.Set;

import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.User;

public interface FieldIDAO extends GenericIDAO<Field> {
	
	Set<Field> findFieldsByUser(User user);
	
}
