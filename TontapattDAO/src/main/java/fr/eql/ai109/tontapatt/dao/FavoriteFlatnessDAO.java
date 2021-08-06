package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.FavoriteFlatness;
import fr.eql.ai109.tontapatt.idao.FavoriteFlatnessIDAO;

@Remote(FavoriteFlatnessIDAO.class)
@Stateless
public class FavoriteFlatnessDAO extends GenericDAO<FavoriteFlatness> implements FavoriteFlatnessIDAO{

}
