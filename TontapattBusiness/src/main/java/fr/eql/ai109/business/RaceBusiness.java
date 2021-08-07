package fr.eql.ai109.business;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.RaceIBusiness;
import fr.eql.ai109.tontapatt.entity.Race;
import fr.eql.ai109.tontapatt.entity.Species;
import fr.eql.ai109.tontapatt.idao.RaceIDAO;

@Remote(RaceIBusiness.class)
@Stateless
public class RaceBusiness implements RaceIBusiness {

	@EJB
	private RaceIDAO raceIDAO;

	@Override
	public Race add(Race t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Race t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Race update(Race t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Race getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Race> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Race> getRacesBySpecies(Species species) {
		return raceIDAO.getRacesBySpecies(species);
	}
}
