package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.UnsubscriptionReason;
import fr.eql.ai109.tontapatt.idao.UnsubsriptionReasonIDAO;

@Remote(UnsubsriptionReasonIDAO.class)
@Stateless
public class UnsubscriptionReasonDAO extends GenericDAO<UnsubscriptionReason>
		implements UnsubsriptionReasonIDAO {

}
