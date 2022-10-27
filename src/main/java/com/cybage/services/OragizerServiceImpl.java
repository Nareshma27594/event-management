package com.cybage.services;

import java.util.List;

import com.cybage.bean.Organizer;
import com.cybage.bean.User;
import com.cybage.dao.DAOImpl;

public class OragizerServiceImpl implements OrganizerService {
	public static DAOImpl dao = new DAOImpl();
	@Override
	public Organizer getOrganizerById(int id) {
		return dao.getOrganizerById(id);
		
	}

	@Override
	public boolean addOrganizer(Organizer organizer) {
		return dao.addOrganizer(organizer);
	}

	@Override
	public int getOrganizerIdByEmail(String email) {
	    return dao.getOrganizerIdByEmail(email);
		
	}

	@Override
	public List<Organizer> getAllOrganizer() {
		
		return dao.getAllOrganizer();
	}

	@Override
	public boolean deleteOrganizer(int organizer_id) {
		
		return dao.deleteOrganizerById(organizer_id);
	}

	@Override
	public boolean setOrganizerName(int id, String name) {
		
		return dao.setOrganizerName(id, name);
	}

	@Override
	public boolean setOrganizerEmail(int id, String email) {
		return dao.setOrganizerEmail(id, email);
	}

	@Override
	public boolean setOrganizerPassword(int id, String password) {
		return dao.setOrganizerPassword(id, password);
	}

	@Override
	public boolean setOrganizerNumber(int id, int number) {
		return dao.setOrganizerNumber(id, number);
	}

}
