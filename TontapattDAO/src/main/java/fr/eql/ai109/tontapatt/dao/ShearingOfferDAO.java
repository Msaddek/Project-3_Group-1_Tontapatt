package fr.eql.ai109.tontapatt.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.User;
import fr.eql.ai109.tontapatt.idao.ShearingOfferIDAO;

@Remote(ShearingOfferIDAO.class)
@Stateless
public class ShearingOfferDAO extends GenericDAO<ShearingOffer>
		implements ShearingOfferIDAO {

	@Override
	public Set<ShearingOffer> searchOfferByFieldLocation(Field field) {
		Set<ShearingOffer> shearingOffers = null;
		LocalDateTime now = LocalDateTime.now();
		String sqlQuery = "SELECT s.*, " + "z.*, "
				+ "u.*, "
				+ "r.* "
				+ "CalcDistance(:fieldLatParam, :fieldLongParam, z.latitude, z.longitude) AS distance,  "
				+ "FROM shearing_offer s "
				+ "INNER JOIN zip_code_city z ON s.zipCodeCity_id=z.id "
				+ "INNER JOIN user u ON s.breeder_id=u.id "
				+ "INNER JOIN race r ON s.race_id=r.id"
				+ "WHERE s.max_travel_dist>=CalcDistance(:fieldLatParam, :fieldLongParam, z.latitude, z.longitude) "
				+ "AND s.withdrawal_date IS NULL "
				+ "AND s.end_date>=:dateTimeNowParam";
		try {
			shearingOffers = (Set<ShearingOffer>) em
					.createNativeQuery(sqlQuery, ShearingOffer.class)
					.setParameter("fieldLatParam",
							field.getZipCodeCity().getLatitude())
					.setParameter("fieldLongParam",
							field.getZipCodeCity().getLongitude())
					.setParameter("dateTimeNowParam", now).getResultList();
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
								.getFirstResult()));
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
								.getFirstResult()));
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
								.getFirstResult()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shearingOffers;
	}

}