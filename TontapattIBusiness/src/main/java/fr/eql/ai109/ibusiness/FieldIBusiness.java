package fr.eql.ai109.ibusiness;

import java.util.Set;

import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.User;

public interface FieldIBusiness extends GenericIBusiness<Field> {
	
	Set<Field> findFieldsByUser(User user);

}
