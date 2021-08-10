package fr.eql.ai109.tontapatt.dao;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.Species;
import fr.eql.ai109.tontapatt.entity.User;
import fr.eql.ai109.tontapatt.idao.ShearingOfferIDAO;

@Remote(ShearingOfferIDAO.class)
@Stateless
public class ShearingOfferDAO extends GenericDAO<ShearingOffer>
		implements ShearingOfferIDAO {

	@Override
	public Set<ShearingOffer> searchOfferByFieldLocation(Field field,
			Species species, LocalDate serviceStartDate,
			LocalDate serviceEndDate) {
		Set<ShearingOffer> shearingOffers = null;
		String sqlQuery = "SELECT s.id, "
				+ "s.address, "
				+ "s.animal_count, "
				+ "s.animal_daily_price, "
				+ "s.creation_date, "
				+ "s.description, "
				+ "s.end_date, "
				+ "s.max_travel_dist, "
				+ "s.name, "
				+ "s.start_date, "
				+ "s.withdrawal_date, "
				+ "s.breeder_id, "
				+ "s.offerWithdrawalReason_id, "
				+ "s.race_id, "
				+ "s.zipCodeCity_id, "
				+ "CalcDistance(:fieldLatParam, :fieldLongParam, z.latitude, z.longitude) AS distance "
				+ "FROM shearing_offer s "
				+ "INNER JOIN zip_code_city z ON s.zipCodeCity_id=z.id "
				+ "INNER JOIN user u ON s.breeder_id=u.id "
				+ "INNER JOIN race r ON s.race_id=r.id "
				+ "INNER JOIN species sp ON r.species_id=sp.id "
				+ "WHERE s.max_travel_dist>=CalcDistance(:fieldLatParam, :fieldLongParam, z.latitude, z.longitude) "
				+ "AND s.withdrawal_date IS NULL "
				+ "AND s.start_date<=:serviceStartDateParam "
				+ "AND s.end_date>=:serviceEndDateParam "
				+ "AND sp.id=:speciesIdParam ";
		try {
			shearingOffers = new HashSet<ShearingOffer>(em
					.createNativeQuery(sqlQuery, ShearingOffer.class)
					.setParameter("fieldLatParam",
							field.getZipCodeCity().getLatitude())
					.setParameter("fieldLongParam",
							field.getZipCodeCity().getLongitude())
					.setParameter("serviceStartDateParam", serviceStartDate)
					.setParameter("serviceEndDateParam", serviceEndDate)
					.setParameter("speciesIdParam", species.getId())
					.getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (ShearingOffer shearingOffer : shearingOffers) {
			System.out.println("****************************" + shearingOffer.getDistance());
		}
		return shearingOffers;
	}

	@Override
	public Set<ShearingOffer> getShearingOffersOfConnectedUser(User user) {
		Set<ShearingOffer> shearingOffers = null;
		String sqlQuery = "SELECT so FROM ShearingOffer so "
				+ "WHERE so.breeder=:userParam AND so.withdrawalDate is NULL";
		System.out.println("je suis laaaaaaaaaaaaaaaaaaa");
		try {
			shearingOffers = new HashSet<ShearingOffer>(em.createQuery(sqlQuery)
					.setParameter("userParam", user).getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shearingOffers;
	}

	@Override
	public Set<ShearingOffer> getExpiredShearingOffersOfConnectedUser(
			User user) {
		LocalDate now = LocalDate.now();
		Set<ShearingOffer> shearingOffers = null;
		String sqlQuery = "SELECT so FROM ShearingOffer so "
				+ "WHERE so.breeder=:userParam AND so.withdrawalDate is NULL "
				+ "AND so.endDate<:dateNowParam";
		try {
			shearingOffers = new HashSet<ShearingOffer>(
					em.createQuery(sqlQuery).setParameter("userParam", user)
							.setParameter("dateNowParam", now).getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shearingOffers;
	}

	@Override
	public Set<ShearingOffer> getInProgressShearingOffersOfConnectedUser(
			User user) {
		LocalDate now = LocalDate.now();
		Set<ShearingOffer> shearingOffers = null;
		String sqlQuery = "SELECT so FROM ShearingOffer so "
				+ "WHERE so.breeder=:userParam AND so.withdrawalDate is NULL "
				+ "AND so.endDate>=:dateNowParam";
		try {
			shearingOffers = new HashSet<ShearingOffer>(
					em.createQuery(sqlQuery).setParameter("userParam", user)
							.setParameter("dateNowParam", now).getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shearingOffers;
	}

}
