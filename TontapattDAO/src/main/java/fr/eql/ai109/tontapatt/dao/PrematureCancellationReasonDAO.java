package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.PrematureCancellationReason;
import fr.eql.ai109.tontapatt.idao.PrematureCancellationReasonIDAO;

@Remote(PrematureCancellationReasonIDAO.class)
@Stateless
public class PrematureCancellationReasonDAO
		extends GenericDAO<PrematureCancellationReason>
		implements PrematureCancellationReasonIDAO {

}
