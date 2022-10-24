package com.cybage.services;

import com.cybage.bean.Organizer;
import com.cybage.bean.User;
import com.cybage.dao.DAOImpl;

public class OragizerServiceImpl implements OrganizerService {
	public static DAOImpl dao = new DAOImpl();
	@Override
	public Organizer getOrganizerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addOrganizer(Organizer user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getOrganizerIdByEmail(String email) {
	    return dao.getOrganizerIdByEmail(email);
		
	}

}
