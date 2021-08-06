package fr.eql.ai109.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.FavoriteFlatnessIBusiness;
import fr.eql.ai109.tontapatt.entity.FavoriteFlatness;
import fr.eql.ai109.tontapatt.idao.FavoriteFlatnessIDAO;

@Remote(FavoriteFlatnessIBusiness.class)
@Stateless
public class FavoriteFlatnessBusiness implements FavoriteFlatnessIBusiness{
	
	@EJB
	private FavoriteFlatnessIDAO favoriteFlatnessIDAO;

	@Override
	public FavoriteFlatness add(FavoriteFlatness t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(FavoriteFlatness t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FavoriteFlatness update(FavoriteFlatness t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FavoriteFlatness getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FavoriteFlatness> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
