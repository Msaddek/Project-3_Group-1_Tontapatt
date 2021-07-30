package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.CancellationReason;
import fr.eql.ai109.tontapatt.idao.CancellationReasonIDAO;

@Remote(CancellationReasonIDAO.class)
@Stateless
public class CancellationReasonDAO extends GenericDAO<CancellationReason>
		implements CancellationReasonIDAO {

}
