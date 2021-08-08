package fr.eql.ai109.tontapatt.idao;

import java.util.Set;

import fr.eql.ai109.tontapatt.entity.Race;
import fr.eql.ai109.tontapatt.entity.Species;

public interface RaceIDAO extends GenericIDAO<Race> {
	
	Set<Race> getRacesBySpecies(Species species);
	
}
