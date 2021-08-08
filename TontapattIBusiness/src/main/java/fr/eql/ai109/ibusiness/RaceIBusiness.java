package fr.eql.ai109.ibusiness;

import java.util.Set;

import fr.eql.ai109.tontapatt.entity.Race;
import fr.eql.ai109.tontapatt.entity.Species;

public interface RaceIBusiness extends GenericIBusiness<Race> {
	
	Set<Race> getRacesBySpecies(Species species); 

}
