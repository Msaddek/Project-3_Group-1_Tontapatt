package fr.eql.ai109.business;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.UserIBusiness;
import fr.eql.ai109.tontapatt.entity.User;
import fr.eql.ai109.tontapatt.idao.UserIDAO;

@Remote(UserIBusiness.class)
@Stateless
public class UserBusiness implements UserIBusiness {

	@EJB
	private UserIDAO userIDAO;

	@Override
	public User add(User t) {
		String path = "resources/img/users/";
		t.setPassword(hashage(t.getPassword()));
		if (t.getPhoto() == null) {
			t.setPhoto(path +"user.png");
		}
		else {
			t.setPhoto(path + t.getPhoto());
		}
		return userIDAO.add(t);
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub

	}

	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean verifyIfUserExists(String email) {
		return userIDAO.verifyIfUserExists(email);
	}

	@Override
	public User connection(String email, String password) {
		password = hashage(password);
		return userIDAO.authenticate(email, password);
	}
	
	private String hashage(String str) {
		
        MessageDigest msg;
		try {
			msg = MessageDigest.getInstance("SHA-256");
		    byte[] hash = msg.digest(str.getBytes(StandardCharsets.UTF_8));
		    StringBuilder s = new StringBuilder();
		    for (byte b : hash) {
		    	s.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		    }
		    str = s.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return str;
 
	}

}
