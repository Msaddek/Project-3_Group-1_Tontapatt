package fr.eql.ai109.tontapatt.dao;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.Race;
import fr.eql.ai109.tontapatt.entity.Species;
import fr.eql.ai109.tontapatt.idao.RaceIDAO;

@Remote(RaceIDAO.class)
@Stateless
public class RaceDAO extends GenericDAO<Race> implements RaceIDAO {

	@Override
	public Set<Race> getRacesBySpecies(Species species) {
		Set<Race> races = null;
		String sqlQuery = "SELECT r FROM Race r WHERE r.species=:speciesParam";
		try {
			races = new HashSet<Race>(em.createQuery(sqlQuery)
					.setParameter("speciesParam", species).getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return races;
	}

}
