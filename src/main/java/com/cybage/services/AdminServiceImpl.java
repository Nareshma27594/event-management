package com.cybage.services;

import com.cybage.dao.DAO;
import com.cybage.dao.DAOImpl;

public class AdminServiceImpl implements AdminService{
    public static DAO dao = new DAOImpl();
	@Override
	public String getPassword(String email) {
		
		return dao.getAdminPassword(email);
	}

	@Override
	public boolean setPassword(String email,String password) {
		// TODO Auto-generated method stub
		return dao.setAdminPassword(email, password);
	}

	@Override
	public boolean setAdminEmail(String previous_email, String new_email) {
		
		return dao.setAdminEmail( previous_email,  new_email);
	}

}
