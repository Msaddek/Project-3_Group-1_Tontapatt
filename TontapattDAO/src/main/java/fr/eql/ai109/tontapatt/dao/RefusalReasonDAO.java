package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.RefusalReason;
import fr.eql.ai109.tontapatt.idao.RefusalReasonIDAO;

@Remote(RefusalReasonIDAO.class)
@Stateless
public class RefusalReasonDAO extends GenericDAO<RefusalReason>
		implements RefusalReasonIDAO {

}
