package com.cybage.services;

import com.cybage.bean.Organizer;


public interface OrganizerService {
	public Organizer getOrganizerById(int id);
	public boolean addOrganizer(Organizer user);
	public int getOrganizerIdByEmail(String email);
}
