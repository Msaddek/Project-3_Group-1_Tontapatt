package fr.eql.ai109.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.SpeciesIBusiness;
import fr.eql.ai109.tontapatt.entity.Species;
import fr.eql.ai109.tontapatt.idao.SpeciesIDAO;

@Remote(SpeciesIBusiness.class)
@Stateless
public class SpeciesBusiness implements SpeciesIBusiness {

	@EJB
	private SpeciesIDAO speciesIDAO;

	@Override
	public Species add(Species t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Species t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Species update(Species t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Species getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Species> getAll() {
		return speciesIDAO.getAll();
	}
}
