package fr.eql.ai109.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.GrassHeightIBusiness;
import fr.eql.ai109.tontapatt.entity.GrassHeight;
import fr.eql.ai109.tontapatt.idao.GrassHeightIDAO;

@Remote(GrassHeightIBusiness.class)
@Stateless
public class GrassHeightBusiness implements GrassHeightIBusiness {

	@EJB
	private GrassHeightIDAO grassHeightIDAO;

	@Override
	public GrassHeight add(GrassHeight t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(GrassHeight t) {
		// TODO Auto-generated method stub

	}

	@Override
	public GrassHeight update(GrassHeight t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GrassHeight getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GrassHeight> getAll() {
		return grassHeightIDAO.getAll();
	}
}
