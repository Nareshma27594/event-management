package com.cybage.services;

import java.util.List;

import com.cybage.bean.Organizer;


public interface OrganizerService {
	public Organizer getOrganizerById(int id);
	public boolean addOrganizer(Organizer user);
	public int getOrganizerIdByEmail(String email);
	public List<Organizer> getAllOrganizer();
	public boolean deleteOrganizer(int organizer_id);
	
	
	
	public boolean setOrganizerName(int id, String name);
    public boolean setOrganizerEmail(int id, String email);
    public boolean setOrganizerPassword(int id, String password);
    public boolean setOrganizerNumber(int id, int number);
   
   
    public boolean deleteEventByOrganizerId(int organizer_id);
  
	
}
