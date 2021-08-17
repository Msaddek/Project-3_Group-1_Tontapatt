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
			LocalDate serviceStartDate, LocalDate serviceEndDate,
			Integer requiredAnimalCount) {
		Set<ShearingOffer> shearingOffers = null;
		LocalDate now = LocalDate.now();
		String sqlQueryPhotos = "SELECT op FROM ShearingOfferPhoto op WHERE "
				+ "op.shearingOffer=:offerParam";
		String sqlQuery = "SELECT s.id, s.address, s.animal_count, "
				+ "s.animal_daily_price, s.creation_date, s.description, "
				+ "s.end_date, s.start_date, s.max_travel_dist, s.name, "
				+ "s.start_date, s.withdrawal_date, s.breeder_id, "
				+ "s.offerWithdrawalReason_id, s.race_id, s.zipCodeCity_id, "
				+ "z.*, u.*, r.*, "
				+ "CalcDistance(:fieldLatParam, :fieldLongParam, z.latitude, z.longitude) AS distance "
				+ "FROM shearing_offer s "
				+ "INNER JOIN zip_code_city z ON s.zipCodeCity_id=z.id "
				+ "INNER JOIN user u ON s.breeder_id=u.id "
				+ "INNER JOIN race r ON s.race_id=r.id "
				+ "LEFT JOIN service se ON s.id=se.shearingOffer_id "
				+ "WHERE s.max_travel_dist>=CalcDistance(:fieldLatParam, :fieldLongParam, z.latitude, z.longitude) "
				+ "AND s.animal_count>=:animalCountParam "
				+ "AND s.withdrawal_date IS NULL "
				+ "AND s.end_date>=:endDateParam "
				+ "AND s.breeder_id!=:userParam "
				+ "AND :startDateParam BETWEEN s.start_date AND s.end_date "
				+ "AND :endDateParam BETWEEN s.start_date AND s.end_date "
				+ "AND se.validation_date IS NULL "
				+ "OR (se.validation_date IS NOT NULL "
				+ "AND :startDateParam NOT BETWEEN se.start_date AND se.end_date "
				+ "AND :endDateParam NOT BETWEEN se.start_date AND se.end_date)";
		try {
			shearingOffers = (new HashSet<ShearingOffer>(em
					.createNativeQuery(sqlQuery, ShearingOffer.class)
					.setParameter("fieldLatParam",
							field.getZipCodeCity().getLatitude())
					.setParameter("fieldLongParam",
							field.getZipCodeCity().getLongitude())
					.setParameter("userParam", field.getOwner().getId())
					.setParameter("startDateParam", serviceStartDate)
					.setParameter("endDateParam", serviceEndDate)
					.setParameter("animalCountParam", requiredAnimalCount)
					.getResultList()));
			for (ShearingOffer shearingOffer : shearingOffers) {
				shearingOffer
						.setPhotos(new HashSet<>(em.createQuery(sqlQueryPhotos)
								.setParameter("offerParam", shearingOffer)
								.getResultList()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shearingOffers;
	}

	@Override
	public Set<ShearingOffer> searchOfferByFieldLocationAndSpecies(Field field,
			LocalDate serviceStartDate, LocalDate serviceEndDate,
			Integer requiredAnimalCount, Species selectedSpecies) {
		Set<ShearingOffer> shearingOffers = null;
		LocalDate now = LocalDate.now();
		String sqlQueryPhotos = "SELECT op FROM ShearingOfferPhoto op WHERE "
				+ "op.shearingOffer=:offerParam";
		String sqlQuery = "SELECT s.id, s.address, s.animal_count, "
				+ "s.animal_daily_price, s.creation_date, s.description, "
				+ "s.end_date, s.start_date, s.max_travel_dist, s.name, "
				+ "s.start_date, s.withdrawal_date, s.breeder_id, "
				+ "s.offerWithdrawalReason_id, s.race_id, s.zipCodeCity_id, "
				+ "z.*, u.*, r.*, "
				+ "CalcDistance(:fieldLatParam, :fieldLongParam, z.latitude, z.longitude) AS distance "
				+ "FROM shearing_offer s "
				+ "INNER JOIN zip_code_city z ON s.zipCodeCity_id=z.id "
				+ "INNER JOIN user u ON s.breeder_id=u.id "
				+ "INNER JOIN race r ON s.race_id=r.id "
				+ "LEFT JOIN service se ON s.id=se.shearingOffer_id "
				+ "WHERE s.max_travel_dist>=CalcDistance(:fieldLatParam, :fieldLongParam, z.latitude, z.longitude) "
				+ "AND s.animal_count>=:animalCountParam "
				+ "AND s.withdrawal_date IS NULL "
				+ "AND s.end_date>=:endDateParam "
				+ "AND s.breeder_id!=:userParam "
				+ "AND r.species_id=:speciesParam "
				+ "AND :startDateParam BETWEEN s.start_date AND s.end_date "
				+ "AND :endDateParam BETWEEN s.start_date AND s.end_date "
				+ "AND (se.validation_date IS NULL "
				+ "OR (se.validation_date IS NOT NULL "
				+ "AND :startDateParam NOT BETWEEN se.start_date AND se.end_date "
				+ "AND :endDateParam NOT BETWEEN se.start_date AND se.end_date))";
		try {
			shearingOffers = (new HashSet<ShearingOffer>(em
					.createNativeQuery(sqlQuery, ShearingOffer.class)
					.setParameter("fieldLatParam",
							field.getZipCodeCity().getLatitude())
					.setParameter("fieldLongParam",
							field.getZipCodeCity().getLongitude())
					.setParameter("userParam", field.getOwner().getId())
					.setParameter("startDateParam", serviceStartDate)
					.setParameter("endDateParam", serviceEndDate)
					.setParameter("animalCountParam", requiredAnimalCount)
					.setParameter("speciesParam", selectedSpecies.getId())
					.getResultList()));
			for (ShearingOffer shearingOffer : shearingOffers) {
				shearingOffer
						.setPhotos(new HashSet<>(em.createQuery(sqlQueryPhotos)
								.setParameter("offerParam", shearingOffer)
								.getResultList()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shearingOffers;
	}

	@Override
	public Set<ShearingOffer> getShearingOffersOfConnectedUser(User user) {
		Set<ShearingOffer> shearingOffers = null;
		String sqlQuery = "SELECT so FROM ShearingOffer so "
				+ "WHERE so.breeder=:userParam AND so.withdrawalDate is NULL";
		String sqlQueryPhotos = "SELECT op FROM ShearingOfferPhoto op WHERE "
				+ "op.shearingOffer=:offerParam";
		try {
			shearingOffers = new HashSet<ShearingOffer>(em.createQuery(sqlQuery)
					.setParameter("userParam", user).getResultList());
			for (ShearingOffer shearingOffer : shearingOffers) {
				shearingOffer
						.setPhotos(new HashSet<>(em.createQuery(sqlQueryPhotos)
								.setParameter("offerParam", shearingOffer)
								.getResultList()));
			}
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
		String sqlQueryPhotos = "SELECT op FROM ShearingOfferPhoto op WHERE "
				+ "op.shearingOffer=:offerParam";
		try {
			shearingOffers = new HashSet<ShearingOffer>(
					em.createQuery(sqlQuery).setParameter("userParam", user)
							.setParameter("dateNowParam", now).getResultList());
			for (ShearingOffer shearingOffer : shearingOffers) {
				shearingOffer
						.setPhotos(new HashSet<>(em.createQuery(sqlQueryPhotos)
								.setParameter("offerParam", shearingOffer)
								.getResultList()));
			}
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
		String sqlQueryShearingOffers = "SELECT so FROM ShearingOffer so "
				+ "WHERE so.breeder=:userParam AND so.withdrawalDate is NULL "
				+ "AND so.endDate>=:dateNowParam";
		String sqlQueryPhotos = "SELECT op FROM ShearingOfferPhoto op WHERE "
				+ "op.shearingOffer=:offerParam";
		try {
			shearingOffers = new HashSet<ShearingOffer>(
					em.createQuery(sqlQueryShearingOffers)
							.setParameter("userParam", user)
							.setParameter("dateNowParam", now).getResultList());
			for (ShearingOffer shearingOffer : shearingOffers) {
				shearingOffer
						.setPhotos(new HashSet<>(em.createQuery(sqlQueryPhotos)
								.setParameter("offerParam", shearingOffer)
								.getResultList()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shearingOffers;
	}

	@Override
	public Set<ShearingOffer> getAllWithPhotos() {
		Set<ShearingOffer> shearingOffers = null;
		String sqlQueryShearingOffers = "SELECT s FROM ShearingOffer s";
		String sqlQueryPhotos = "SELECT op FROM ShearingOfferPhoto op WHERE "
				+ "op.shearingOffer=:offerParam";
		try {
			shearingOffers = new HashSet<ShearingOffer>(
					em.createQuery(sqlQueryShearingOffers).getResultList());
			for (ShearingOffer shearingOffer : shearingOffers) {
				shearingOffer
						.setPhotos(new HashSet<>(em.createQuery(sqlQueryPhotos)
								.setParameter("offerParam", shearingOffer)
								.getResultList()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shearingOffers;
	}

	@Override
	public Set<ShearingOffer> getLastThreeByUser(User connectedUser) {
		Set<ShearingOffer> shearingOffers = null;
		LocalDate now = LocalDate.now();
		String sqlQueryShearingOffers = "SELECT so FROM ShearingOffer so "
				+ "WHERE so.breeder=:userParam AND so.withdrawalDate is NULL "
				+ "AND so.endDate>=:dateNowParam ORDER BY so.id DESC";
		String sqlQueryPhotos = "SELECT op FROM ShearingOfferPhoto op WHERE "
				+ "op.shearingOffer=:offerParam";
		try {
			shearingOffers = new HashSet<ShearingOffer>(
					em.createQuery(sqlQueryShearingOffers)
							.setParameter("userParam", connectedUser)
							.setParameter("dateNowParam", now).setMaxResults(3)
							.getResultList());
			for (ShearingOffer shearingOffer : shearingOffers) {
				shearingOffer
						.setPhotos(new HashSet<>(em.createQuery(sqlQueryPhotos)
								.setParameter("offerParam", shearingOffer)
								.getResultList()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shearingOffers;
	}

	@Override
	public Set<ShearingOffer> getLastThree() {
		Set<ShearingOffer> shearingOffers = null;
		LocalDate now = LocalDate.now();
		String sqlQueryShearingOffers = "SELECT so FROM ShearingOffer so "
				+ "WHERE so.withdrawalDate is NULL "
				+ "AND so.endDate>=:dateNowParam ORDER BY so.id DESC";
		String sqlQueryPhotos = "SELECT op FROM ShearingOfferPhoto op WHERE "
				+ "op.shearingOffer=:offerParam";
		try {
			shearingOffers = new HashSet<ShearingOffer>(
					em.createQuery(sqlQueryShearingOffers)
							.setParameter("dateNowParam", now).setMaxResults(3)
							.getResultList());
			for (ShearingOffer shearingOffer : shearingOffers) {
				shearingOffer
						.setPhotos(new HashSet<>(em.createQuery(sqlQueryPhotos)
								.setParameter("offerParam", shearingOffer)
								.getResultList()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shearingOffers;
	}

}