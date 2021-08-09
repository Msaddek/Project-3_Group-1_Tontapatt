package fr.eql.ai109.tontapatt.idao;

import java.util.Set;

import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.FieldPhoto;

public interface FieldPhotoIDAO extends GenericIDAO<FieldPhoto> {
	
	Set<FieldPhoto> findPhotosByField(Field field);
	
}
