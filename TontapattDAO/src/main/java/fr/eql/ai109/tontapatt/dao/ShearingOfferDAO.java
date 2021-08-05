package fr.eql.ai109.tontapatt.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.ZipCodeCity;
import fr.eql.ai109.tontapatt.idao.ShearingOfferIDAO;

@Remote(ShearingOfferIDAO.class)
@Stateless
public class ShearingOfferDAO extends GenericDAO<ShearingOffer>
		implements ShearingOfferIDAO {

	@Override
	public List<ShearingOffer> searchOfferByFieldLocation(Field field) {
		List<ShearingOffer> shearingOffers = null;
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
			shearingOffers = (List<ShearingOffer>) em
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

	public ZipCodeCity calculateDistance() {
		ZipCodeCity distance = null;
		try {
			System.out.println(em);
			System.out.println("ok");

			String sqlString = "SELECT id, name, zip_code, latitude, longitude, "
					+ "CalcDistance(41.9714498244, 9.24775602009, 42.3941662475, "
					+ "9.37311777417) AS distance FROM zip_code_city WHERE id=1";

			distance = (ZipCodeCity) em
					.createNativeQuery(sqlString, ZipCodeCity.class)
					.getSingleResult();
			System.out.println(distance.getName());
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(em);
		return distance;
	}

}
