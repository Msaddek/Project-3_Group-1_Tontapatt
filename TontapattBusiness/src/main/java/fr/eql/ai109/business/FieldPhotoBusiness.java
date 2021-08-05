package fr.eql.ai109.business;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.FieldPhotoIBusiness;
import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.FieldPhoto;
import fr.eql.ai109.tontapatt.idao.FieldPhotoIDAO;

@Remote(FieldPhotoIBusiness.class)
@Stateless
public class FieldPhotoBusiness implements FieldPhotoIBusiness {

	@EJB
	private FieldPhotoIDAO fieldPhotoIDAO;

	@Override
	public FieldPhoto add(FieldPhoto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(FieldPhoto t) {
		// TODO Auto-generated method stub

	}

	@Override
	public FieldPhoto update(FieldPhoto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FieldPhoto getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FieldPhoto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<FieldPhoto> findPhotosByField(Field field) {
		// TODO Auto-generated method stub
		return null;
	}
}
