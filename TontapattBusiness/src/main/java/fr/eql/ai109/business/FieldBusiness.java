package fr.eql.ai109.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.FieldIBusiness;
import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.idao.FieldIDAO;

@Remote(FieldIBusiness.class)
@Stateless
public class FieldBusiness extends GenericBusiness<Field>
		implements FieldIBusiness {

	@EJB
	private FieldIDAO fieldIDAO;
}
