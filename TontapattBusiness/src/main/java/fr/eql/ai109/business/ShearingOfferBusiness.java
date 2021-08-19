package fr.eql.ai109.business;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.ShearingOfferIBusiness;
import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.Species;
import fr.eql.ai109.tontapatt.entity.User;
import fr.eql.ai109.tontapatt.idao.ShearingOfferIDAO;

@Remote(ShearingOfferIBusiness.class)
@Stateless
public class ShearingOfferBusiness implements ShearingOfferIBusiness {

	@EJB
	private ShearingOfferIDAO shearingOfferIDAO;

	@Override
	public ShearingOffer add(ShearingOffer t) {
		return shearingOfferIDAO.add(t);
	}

	@Override
	public void delete(ShearingOffer t) {
		// TODO Auto-generated method stub

	}

	@Override
	public ShearingOffer update(ShearingOffer t) {
		return shearingOfferIDAO.update(t);
	}

	@Override
	public ShearingOffer getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShearingOffer> getAll() {
		return shearingOfferIDAO.getAll();
	}

	@Override
	public Set<ShearingOffer> searchOfferByFieldLocation(Field field,
			LocalDate startDate, LocalDate endDate,
			Integer requiredAnimalCount) {
		return shearingOfferIDAO.searchOfferByFieldLocation(field, startDate,
				endDate, requiredAnimalCount);
	}

	@Override
	public Set<ShearingOffer> getShearingOffersOfConnectedUser(User user) {
		return shearingOfferIDAO.getShearingOffersOfConnectedUser(user);
	}

	@Override
	public Set<ShearingOffer> getExpiredShearingOffersOfConnectedUser(
			User user) {
		return shearingOfferIDAO.getExpiredShearingOffersOfConnectedUser(user);
	}

	@Override
	public Set<ShearingOffer> getInProgressShearingOffersOfConnectedUser(
			User user) {
		return shearingOfferIDAO
				.getInProgressShearingOffersOfConnectedUser(user);
	}

	@Override
	public ShearingOffer createShearingOffer(ShearingOffer shearingOffer) {
		return shearingOfferIDAO.add(shearingOffer);
	}

	@Override
	public Set<ShearingOffer> searchOfferByFieldLocationAndSpecies(Field field,
			LocalDate serviceStartDate, LocalDate serviceEndDate,
			Integer requiredAnimalCount, Species selectedSpecies) {
		return shearingOfferIDAO.searchOfferByFieldLocationAndSpecies(field,
				serviceStartDate, serviceEndDate, requiredAnimalCount,
				selectedSpecies);
	}

	@Override
	public Set<ShearingOffer> getAllWithPhotos() {
		return shearingOfferIDAO.getAllWithPhotos();
	}
	
	@Override
	public Set<ShearingOffer> getLastThreeByUser(User connectedUser) {
		return shearingOfferIDAO.getLastThreeByUser(connectedUser);
	}

	@Override
	public Set<ShearingOffer> getLastThree() {
		
		return shearingOfferIDAO.getLastThree();
	}

	@Override
	public Set<ShearingOffer> getLastTwenty() {
		return shearingOfferIDAO.getLastTwenty();
	}

}
