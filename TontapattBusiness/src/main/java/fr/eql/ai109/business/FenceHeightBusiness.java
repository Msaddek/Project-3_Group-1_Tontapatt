package fr.eql.ai109.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.FenceHeightIBusiness;
import fr.eql.ai109.tontapatt.entity.FenceHeight;
import fr.eql.ai109.tontapatt.idao.FenceHeightIDAO;

@Remote(FenceHeightIBusiness.class)
@Stateless
public class FenceHeightBusiness implements FenceHeightIBusiness {

	@EJB
	private FenceHeightIDAO fenceHeightIDAO;

	@Override
	public FenceHeight add(FenceHeight t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(FenceHeight t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FenceHeight update(FenceHeight t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FenceHeight getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FenceHeight> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
