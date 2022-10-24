package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.cybage.bean.Booking;
import com.cybage.bean.Event;
import com.cybage.bean.Organizer;
import com.cybage.bean.User;
import com.cybage.utility.JDBCUtility;

public class DAOImpl implements DAO{

	@Override
	public User getUserById(int id) {
		try(Connection connect = JDBCUtility.getConnection()){
			
			PreparedStatement stmt = connect.prepareStatement("select * from user where user_id=?");
			   stmt.setInt(1, id);
			   ResultSet set= stmt.executeQuery();
			   while(set.next())  
				   return new User(set.getInt(1), set.getString(2),set.getString(3), set.getString(4),set.getInt(5));
			   // 	public User(int id,String name, String email, String password, int number)
			  
			
		}
		catch(Exception e) {
			System.out.println("Error while getting user getUserById(int id)"+e);
		}
		return null;
	}

	@Override
	public Organizer getOrganizerById(int id) {

        try(Connection connection = JDBCUtility.getConnection()){
			
		}
		catch(Exception e) {
			System.out.println("");
		}
		
		return null;
	}

	@Override
	public boolean addUser(User user) {
		
       try(Connection connect = JDBCUtility.getConnection()){
			
    	   PreparedStatement pstmt = connect.prepareStatement("insert into user(name, email, password, phone) values(?,?,?,?)");  
		   pstmt.setString(1, user.getName());
		   pstmt.setString(2, user.getEmail());
		   pstmt.setString(3, user.getPassword());
		   pstmt.setInt(4, user.getPhone());
		   pstmt.executeUpdate();
		   return true;
    	   
		}
		catch(Exception e) {
			System.out.println("Erroe while addding an user addUser(User user)"+e);
		}
		
		return false;
	}

	@Override
	public boolean setUserName(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setUserEmail(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setUserPassword(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getUserIdByEmail(String email) {
		
try(Connection connect = JDBCUtility.getConnection()){
			
			PreparedStatement stmt = connect.prepareStatement("select user_id from user where email=?");
			   stmt.setString(1, email);
			   ResultSet set= stmt.executeQuery();
			   while(set.next())  
				   return set.getInt(1);
			   
			  
			
		}
		catch(Exception e) {
			System.out.println("Error while getting getUserIdByEmail(String email)"+e);
		}
		
		
		return 0;
	}
	
	
	

	@Override
	public boolean setOrganizerName(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setOrganizerEmail(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setOrganizerPassword(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getOrganizerIdByEmail(String email) {

		
try(Connection connect = JDBCUtility.getConnection()){
			
			PreparedStatement stmt = connect.prepareStatement("select organizer_id from organizer where email=?");
			   stmt.setString(1, email);
			   ResultSet set= stmt.executeQuery();
			   while(set.next())  
				   return set.getInt(1);
			   
			  
			
		}
		catch(Exception e) {
			System.out.println("Error while getting getOrganizerIdByEmail(String email)"+e);
		}
		
		
		return 0;
	}

	@Override
	public boolean addOrganizer(Organizer organizer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getAllEvents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getBookedEvents(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEventsByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> getAllBooking() {
		// TODO Auto-generated method stub
		return null;
	}

}
