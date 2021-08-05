package fr.eql.ai109.ibusiness;

import java.util.Set;

import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.FieldPhoto;

public interface FieldPhotoIBusiness extends GenericIBusiness<FieldPhoto> {

	Set<FieldPhoto> findPhotosByField(Field field);

}
