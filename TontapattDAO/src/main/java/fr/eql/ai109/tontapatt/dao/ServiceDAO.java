package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.Service;
import fr.eql.ai109.tontapatt.idao.ServiceIDAO;

@Remote(ServiceIDAO.class)
@Stateless
public class ServiceDAO extends GenericDAO<Service>
		implements ServiceIDAO {

}
