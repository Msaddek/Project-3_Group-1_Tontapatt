package fr.eql.ai109.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.FieldIBusiness;
import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.idao.FieldIDAO;

@Remote(FieldIBusiness.class)
@Stateless
public class FieldBusiness implements FieldIBusiness {

	@EJB
	private FieldIDAO fieldIDAO;

	@Override
	public Field add(Field t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Field t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Field update(Field t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Field getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Field> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
