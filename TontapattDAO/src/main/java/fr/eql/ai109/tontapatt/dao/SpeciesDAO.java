package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.Species;
import fr.eql.ai109.tontapatt.idao.SpeciesIDAO;

@Remote(SpeciesIDAO.class)
@Stateless
public class SpeciesDAO extends GenericDAO<Species>
		implements SpeciesIDAO {

}
