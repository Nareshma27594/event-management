package com.cybage.services;

import com.cybage.bean.User;
import com.cybage.dao.DAO;
import com.cybage.dao.DAOImpl;

public class UserServideImpl implements UserService{
	public static DAO dao = new DAOImpl();
@Override	
public User getUserById(int id) {		
		return dao.getUserById(id);	
	}
@Override
public boolean addUser(User user) {
	return dao.addUser(user);
}

public static void main(String args[]) {
	UserServideImpl impl = new UserServideImpl();
	// public User(int id,String name, String email, String password, int number) {
	System.out.println(impl.addUser(new User("dname","demail","upass",123)));
//	System.out.println(impl.getUserById(1));
}
@Override
public int getUserIdByEmail(String email) {
	
	return dao.getUserIdByEmail(email);
}

}
