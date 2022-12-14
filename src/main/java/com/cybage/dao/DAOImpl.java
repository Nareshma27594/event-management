package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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

try(Connection connect = JDBCUtility.getConnection()){
			
			PreparedStatement stmt = connect.prepareStatement("select * from organizer where organizer_id=?");
			   stmt.setInt(1, id);
			   ResultSet set= stmt.executeQuery();
			   while(set.next())  
				   return new Organizer(set.getInt(1), set.getString(2),set.getString(3), set.getString(4),set.getInt(5));
			   // 	public User(int id,String name, String email, String password, int number)
			  
			
		}
		catch(Exception e) {
			System.out.println("Error while getting user getUserById(int id)"+e);
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

	/////////////////////////////////////
	
	@Override
	public boolean setUserName(int id, String name) {
		try(Connection connect = JDBCUtility.getConnection()){
			
	    	   PreparedStatement pstmt = connect.prepareStatement("update user set name=? where user_id=?");  
			   pstmt.setString(1, name);
			   pstmt.setInt(2, id);
			   pstmt.executeUpdate();
			   return true;
	    	   
			}
			catch(Exception e) {
				System.out.println("Error while setting name setUserName(int id,String name)"+e);
			}
			
			return false;
	}

	@Override
	public boolean setUserEmail(int id, String email) {
		try(Connection connect = JDBCUtility.getConnection()){
			
	    	   PreparedStatement pstmt = connect.prepareStatement("update user set email=? where user_id=?");  
			   pstmt.setString(1, email);
			   pstmt.setInt(2, id);
			   pstmt.executeUpdate();
			   return true;
	    	   
			}
			catch(Exception e) {
				System.out.println("Error while setting name setUserEmail(int id,String email)"+e);
			}
			
			return false;
	}

	@Override
	public boolean setUserPassword(int id, String password) {
		
		try(Connection connect = JDBCUtility.getConnection()){
			
	    	   PreparedStatement pstmt = connect.prepareStatement("update user set password=? where user_id=?");  
			   pstmt.setString(1, password);
			   pstmt.setInt(2, id);
			   pstmt.executeUpdate();
			   return true;
	    	   
			}
			catch(Exception e) {
				System.out.println("Error while setting password setUserPassword(int id,String password)"+e);
			}
			
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
	public boolean setOrganizerName(int id, String name) {
	    
		 try(Connection connect = JDBCUtility.getConnection()){
				
	    	   PreparedStatement pstmt = connect.prepareStatement("update organizer set name=? where organizer_id=?");  
			   pstmt.setString(1, name);
			   pstmt.setInt(2, id);
			   pstmt.executeUpdate();
			   return true;
	    	   
			}
			catch(Exception e) {
				System.out.println("Error while setting organizer_name setOrganizerName(int id, String name)"+e);
			}
			
			return false;
		
	}

	@Override
	public boolean setOrganizerEmail(int id, String email) {
		try(Connection connect = JDBCUtility.getConnection()){
			
	    	   PreparedStatement pstmt = connect.prepareStatement("update organizer set email=? where organizer_id=?");  
			   pstmt.setString(1, email);
			   pstmt.setInt(2, id);
			   pstmt.executeUpdate();
			   return true;
	    	   
			}
			catch(Exception e) {
				System.out.println("Error while setting organizer email setOrganizerEmail(int id, String email)"+e);
			}
			
			return false;
	}

	@Override
	public boolean setOrganizerPassword(int id, String password) {
		
		try(Connection connect = JDBCUtility.getConnection()){
			
	    	   PreparedStatement pstmt = connect.prepareStatement("update organizer set password=? where organizer_id=?");  
			   pstmt.setString(1, password);
			   pstmt.setInt(2, id);
			   pstmt.executeUpdate();
			   return true;
	    	   
			}
			catch(Exception e) {
				System.out.println("Error while setting organizer password setOrganizerPassword(int id, String password)"+e);
			}
			
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
		
		 try(Connection connect = JDBCUtility.getConnection()){
				
	    	   PreparedStatement pstmt = connect.prepareStatement("insert into organizer(name, email, password, phone) values(?,?,?,?)");  
			   pstmt.setString(1, organizer.getName());
			   pstmt.setString(2, organizer.getEmail());
			   pstmt.setString(3, organizer.getPassword());
			   pstmt.setInt(4, 2141);
			   pstmt.executeUpdate();
			   return true;
	    	   
			}
			catch(Exception e) {
				System.out.println("Erroe while addding an Organizer addUser(Organizer organizer)"+e);
			}
			
			return false;
		
		
	}

	@Override
	public List<User> getAllUser() {

		try(Connection connect = JDBCUtility.getConnection()){
			List<User> list = new ArrayList<>();
			Statement stmt = connect.createStatement();
			ResultSet set = stmt.executeQuery("select * from user");
			   
//			   ResultSet set= stmt.executeQuery();
			   while(set.next())  
				    list.add(new User(set.getInt(1), set.getString(2),set.getString(3), set.getString(4),set.getInt(5)));
			   // 	public User(int id,String name, String email, String password, int number)
			   
			 return list; 
			
		}
		catch(Exception e) {
			System.out.println("Error while getting userlist public List<User> getAllUser()"+e);
		}
		return null;
	}

	@Override
	public List<Event> getAllEvents() {
		


		try(Connection connect = JDBCUtility.getConnection()){
			List<Event> list = new ArrayList<>();
			Statement stmt = connect.createStatement();
			ResultSet set = stmt.executeQuery("select * from event");
			   
		   
		//	public Event(int event_id, String name, String venue, int price, int organizer_id, String category, String date) 
				
			
			
			   while(set.next())  
				    list.add(new Event(set.getInt(1), set.getString(2),set.getString(3), set.getInt(4),set.getInt(5), set.getString(6), set.getString(7)));
			   
			 return list; 
			
		}
		catch(Exception e) {
			System.out.println("Error while getting eventlist public List<Event> getAllEvents()"+e);
		}
		return null;
		
	}

	/*returns event booked by user**/
	@Override
	public List<Event> getBookedEvents(int user_id) {
		List<Event> list = new ArrayList<>();
try(Connection connect = JDBCUtility.getConnection()){
			
			PreparedStatement stmt = connect.prepareStatement("select * from event where event_id IN ( select event_id from booking where user_id=?)");
			   stmt.setInt(1, user_id);
			   ResultSet set= stmt.executeQuery();
			   while(set.next())  {

		// public           Event(int event_id, String name, String venue, int price, int organizer_id, String category, String date) 		   
				   list.add(new Event(set.getInt(1), set.getString(2),set.getString(3), set.getInt(4),set.getInt(5), set.getString(6), set.getString(7)));
				    //
			   }
			 return list; 
			
		}
		catch(Exception e) {
			System.out.println("Error while getting user getBookedEvnts(int id)"+e);
		}
		return null;
	}

	@Override
	public List<Event> getEventsByCategory(String category) {
		
		List<Event> list = new ArrayList<>();
try(Connection connect = JDBCUtility.getConnection()){
			
			PreparedStatement stmt = connect.prepareStatement("select * from event where category=?");
			   stmt.setString(1, category);
			   ResultSet set= stmt.executeQuery();
			   while(set.next())  {

		// public           Event(int event_id, String name, String venue, int price, int organizer_id, String category, String date) 		   
				   list.add(new Event(set.getInt(1), set.getString(2),set.getString(3), set.getInt(4),set.getInt(5), set.getString(6), set.getString(7)));
				    //
			   }
			 return list; 
			
		}
		catch(Exception e) {
			System.out.println("Error while getting user getEventsByCategory(String category)"+e);
		}
		return null;
		
	}

	@Override
	public List<Booking> getAllBooking() {
		
		List<Booking> list = new ArrayList<>();
		try(Connection connect = JDBCUtility.getConnection()){
					
			Statement stmt = connect.createStatement();
					   ResultSet set= stmt.executeQuery("select * from booking");
					   while(set.next())  {

				// public           Event(int event_id, String name, String venue, int price, int organizer_id, String category, String date) 		   
						   list.add(new Booking(set.getInt(1), set.getInt(2),set.getInt(3)));
						    //
					   }
					 return list; 
					
				}
				catch(Exception e) {
					System.out.println("Error while getting booking getAllBooking()"+e);
				}
				return null;
		
	}

	@Override
	public boolean setEventName(int id,String event_name) {
		try(Connection connect = JDBCUtility.getConnection()){
			
	    	   PreparedStatement pstmt = connect.prepareStatement("update event set name=? where event_id=?");  
			   pstmt.setString(1, event_name);
			   pstmt.setInt(2, id);
			   pstmt.executeUpdate();
			   return true;
	    	   
			}
			catch(Exception e) {
				System.out.println("Error while setting event_name setEventName(int id,String event_name)"+e);
			}
			
			return false;
	}

	@Override
	public boolean setEventVenue(int event_id,String venue) {

		try(Connection connect = JDBCUtility.getConnection()){
			
	    	   PreparedStatement pstmt = connect.prepareStatement("update event set venue=? where event_id=?");  
			   pstmt.setString(1, venue);
			   pstmt.setInt(2, event_id);
			   pstmt.executeUpdate();
			   return true;
	    	   
			}
			catch(Exception e) {
				System.out.println("Error while setting event_name setEventVenue(int id,String venue)"+e);
			}
			
			return false;
	}

	@Override
	public boolean setEventPrice(int event_id,int price) {
		try(Connection connect = JDBCUtility.getConnection()){
			
	    	   PreparedStatement pstmt = connect.prepareStatement("update event set price=? where event_id=?");  
			   pstmt.setInt(1, price);
			   pstmt.setInt(2, event_id);
			   pstmt.executeUpdate();
			   return true;
	    	   
			}
			catch(Exception e) {
				System.out.println("Error while setting pric setEventPrice(int id,int price)"+e);
			}
			
			return false;
	}

	@Override
	public boolean setEventCategory(int event_id,String category) {
		
		try(Connection connect = JDBCUtility.getConnection()){
			
	    	   PreparedStatement pstmt = connect.prepareStatement("update event set category=? where event_id=?");  
			   pstmt.setString(1, category);
			   pstmt.setInt(2, event_id);
			   pstmt.executeUpdate();
			   return true;
	    	   
			}
			catch(Exception e) {
				System.out.println("Error while setting category setEventCategory(int event_id,String category)"+e);
			}
			
			return false;
		
	}

	
	@Override
	public boolean setEventDateTime(int event_id,String dateTime) {
		

		try(Connection connect = JDBCUtility.getConnection()){
			
	    	   PreparedStatement pstmt = connect.prepareStatement("update event set datetime=? where event_id=?");  
			   pstmt.setString(1, dateTime);
			   pstmt.setInt(2, event_id);
			   pstmt.executeUpdate();
			   return true;
	    	   
			}
			catch(Exception e) {
				System.out.println("Error while setting dateTime setEventDateTime(int event_id,String dateTime)"+e);
			}
			
			return false;
		
	}

	@Override
	public boolean addEvent(Event event) {
		 try(Connection connect = JDBCUtility.getConnection()){						 
			 
	    	   PreparedStatement pstmt = connect.prepareStatement("insert into event(name, venue, price, organizer_id, category, date) values(?,?,?,?,?,?)");  
			   pstmt.setString(1, event.getName());
			   pstmt.setString(2, event.getVenue());
			   pstmt.setInt(3, event.getPrice());
			   pstmt.setInt(4, event.getOrganizer_id());
			   pstmt.setString(5, event.getCategory());
			   pstmt.setString(6, event.getDate());
			   pstmt.executeUpdate();
			   return true;
	    	   
			}
			catch(Exception e) {
				System.out.println("Erroe while addding an event addEvent(Event event)"+e);
			}
			
			return false;
	}

	// ---------------------------deleteUser---------------------------------
	@Override
	public boolean deleteUserById(int id) {
		try(Connection connect = JDBCUtility.getConnection()){						 
			   DAOImpl impl = new DAOImpl();
			   impl.deleteBookingByUserId(id);
	    	   PreparedStatement pstmt = connect.prepareStatement("delete from user where user_id=?");  
			   pstmt.setInt(1, id);
			   pstmt.executeUpdate();
			   return true;
	    	   
			}
			catch(Exception e) {
				System.out.println("Erroe while deleting an user deleteUserById(int id)"+e);
			}
			
			return false;
	}
	
//--------------------------deleteOrganizer------------------
	@Override
	public boolean deleteOrganizerById(int organizer_id) {
		try(Connection connect = JDBCUtility.getConnection()){						 
			   DAOImpl daoImpl = new DAOImpl();
			   daoImpl.deleteEventByOrganizerId(organizer_id);
	    	   PreparedStatement pstmt = connect.prepareStatement("delete from organizer where organizer_id=?");  
			   pstmt.setInt(1, organizer_id);
			   pstmt.executeUpdate();
			   return true;
	    	   
			}
			catch(Exception e) {
				System.out.println("Erroe while deleting an Organizer deleteOrganizerById(int organizer_id)"+e);
			}
			
			return false;
	}

//--------------------------deleteEvent----------------------------	
	@Override
	public boolean deleteEventById(int event_id) {
		
		try(Connection connect = JDBCUtility.getConnection()){						 
			   DAOImpl daoImpl = new DAOImpl();
			   daoImpl.deleteBookingByEventId(event_id);
	    	   PreparedStatement pstmt = connect.prepareStatement("delete from event where event_id=?");  
			   pstmt.setInt(1, event_id);
			   pstmt.executeUpdate();
			   return true;
	    	   
			}
			catch(Exception e) {
				System.out.println("Erroe while deleting an Event deleteEventById(int event_id)"+e);
			}
			
			return false;
		
	}

	@Override
	public boolean deleteEventByOrganizerId(int organizer_id) {
		try(Connection connect = JDBCUtility.getConnection()){						 
			DAOImpl daoImpl = new DAOImpl();
			
		List<Event> list = daoImpl.getEventsOrganizedByOrganizer(organizer_id);
		
		for(Event event:list)
		daoImpl.deleteEventById(event.getEvent_id());
		
		
			/// Get the list events organized by oragnizer
	    	   PreparedStatement pstmt = connect.prepareStatement("delete from event where organizer_id=?");  
			   pstmt.setInt(1, organizer_id);
			   pstmt.executeUpdate();
			   return true;
	    	   
			}
			catch(Exception e) {
				System.out.println("Erroe while deleting an Event deleteEventByOrganizerId(int organizer_id)"+e);
			}
			
			return false;
			
	}

	@Override
	public boolean addBooking(Booking booking) {
		try(Connection connection  = JDBCUtility.getConnection()){
			PreparedStatement pstmt = connection.prepareStatement("insert into booking(event_id, user_id) values(?,?)");
            pstmt.setInt(1,booking.getEvent_id());
            pstmt.setInt(2,booking.getUser_id());
            pstmt.executeUpdate();
            return true;
			//			pstmt.setInt(1, booking);
		}
		catch(Exception e) {
			System.out.println("Error while addinng booking addBooking(Booking booking)");
		}
		return false;
	}

	@Override
	public boolean deleteBookingById(int booking_id) {
		try(Connection connect = JDBCUtility.getConnection()){
			PreparedStatement pstmt = connect.prepareStatement("delete from booking where booking_id = ?");
			pstmt.setInt(1, booking_id);
			pstmt.executeUpdate();
			return true;
		}
		catch(Exception e) {
			System.out.println("Error while deleting Booking deleteBookingById(int booking_id)");
		}
		return false;
	}

	@Override
	public boolean deleteBookingByUserId(int user_id) {
		try(Connection connect = JDBCUtility.getConnection()){
			PreparedStatement pstmt = connect.prepareStatement("delete from booking where user_id = ?");
			pstmt.setInt(1, user_id);
			pstmt.executeUpdate();
			return true;
		}
		catch(Exception e) {
			System.out.println("Error while deleting Booking deleteBookingByUserId(int user_id)");
		}
		return false;
		
	}

	@Override
	public boolean deleteBookingByEventId(int event_id) {
		try(Connection connect = JDBCUtility.getConnection()){
			PreparedStatement pstmt = connect.prepareStatement("delete from booking where event_id = ?");
			pstmt.setInt(1, event_id);
			pstmt.executeUpdate();
			return true;
		}
		catch(Exception e) {
			System.out.println("Error while deleting Booking deleteBookingByEventId(int event_id)");
		}
		return false;
	}

	@Override
	public List<Event> getEventsOrganizedByOrganizer(int organizer_id) {
		

		List<Event> list = new ArrayList<>();
		try(Connection connect = JDBCUtility.getConnection()){
					
			PreparedStatement pstmt = connect.prepareStatement("select * from event where organizer_id=?");
			pstmt.setInt(1, organizer_id);
			
					   ResultSet set= pstmt.executeQuery();
					   while(set.next())  {

				// public           Event(int event_id, String name, String venue, int price, int organizer_id, String category, String date) 		   
						   list.add(new Event(set.getInt(1), set.getString(2),set.getString(3), set.getInt(4), set.getInt(5), set.getString(6),set.getString(7)));
						    //
					   }
					 return list; 
					
				}
				catch(Exception e) {
					System.out.println("Error while getting events getEventsOrganizedByOrganizer(int organizer_id)"+e);
				}
				return null;
		
	}

	@Override
	public boolean setUserNumber(int user_id, int phone_number) {
		try(Connection connect = JDBCUtility.getConnection()){ ///////////////////////////////////////
			PreparedStatement pstmt = connect.prepareStatement("update user set phone =? where  user_id = ?");
			pstmt.setInt(1, user_id);
			pstmt.setInt(2, phone_number);
			pstmt.executeUpdate();
			return true;
		}
		catch(Exception e) {
			System.out.println("Error while setting user phone number boolean setUserNumber(int user_id, int phone_number)");
		}
		return false;
	}

	@Override
	public boolean setOrganizerNumber(int organizer_id, int phone_number) {
		try(Connection connect = JDBCUtility.getConnection()){
			PreparedStatement pstmt = connect.prepareStatement("update organizer set phone =? where  organizer_id = ?");
			pstmt.setInt(1, organizer_id);
			pstmt.setInt(2, phone_number);
			pstmt.executeUpdate();
			return true;
		}
		catch(Exception e) {
			System.out.println("Error while setting organizer phone number boolean setOrganizerNumber(int organizer_id, int phone_number)");
		}
		return false;
	}

	@Override
	public List<Organizer> getAllOrganizer() {
		
		List<Organizer> list = new ArrayList<>();
		try(Connection connect = JDBCUtility.getConnection()){
					
					Statement stmt = connect.createStatement();
					  
					   ResultSet set= stmt.executeQuery("select * from organizer");
					   while(set.next())  {
	   
						   list.add(new Organizer(set.getInt(1), set.getString(2),set.getString(3), set.getString(4),set.getInt(5)));
						    
					   }
					 return list; 
					
				}
				catch(Exception e) {
					System.out.println("Error while getting lsit of organizer List<Organizer> getAllOrganizer()"+e);
				}
				return null;
		
		
	}

	@Override
	public Event getEventById(int id) {
try(Connection connect = JDBCUtility.getConnection()){
			
			PreparedStatement stmt = connect.prepareStatement("select * from event where event_id=?");
			   stmt.setInt(1, id);
			   ResultSet set= stmt.executeQuery();
			   
			   
			   
			   
			   
			   
//			   public Event(int event_id, String name, String venue, int price, int organizer_id, String category, String date) {
		   
			   while(set.next())  
				   return new Event(set.getInt(1), set.getString(2),set.getString(3), set.getInt(4),set.getInt(5),set.getString(6),set.getString(7));
			  
			
		}
		catch(Exception e) {
			System.out.println("Error while getting Event getEventById(int id)"+e);
		}
		return null;
	}

	@Override
	public boolean setOrganizerIdOfEventById(int event_id, int organizer_id) {
		try(Connection connect = JDBCUtility.getConnection()){ ///////////////////////////////////////
			PreparedStatement pstmt = connect.prepareStatement("update event set organizer_id =? where  event_id = ?");
			pstmt.setInt(1, organizer_id);
			pstmt.setInt(2, event_id);
			pstmt.executeUpdate();
			return true;
		}
		catch(Exception e) {
			System.out.println("Error while setting organizer id of event id boolean setOrganizerIdOfEventById(int event_id, int organizer_id)");
		}
		return false;
	}

	@Override
	public Booking getBooking(int booking_id) {
try(Connection connect = JDBCUtility.getConnection()){
			
			PreparedStatement stmt = connect.prepareStatement("select * from booking where booking_id=?");
			   stmt.setInt(1, booking_id);
			   ResultSet set= stmt.executeQuery();
			   while(set.next())  
				   return new Booking(set.getInt(1), set.getInt(2),set.getInt(3));
			   // 	public Booking(int bookingid,int event_id, int  user_id, String password, int number)
			  
			
		}
		catch(Exception e) {
			System.out.println("Error while getting user getUserById(int id)"+e);
		}
		return null;
	}

	@Override
	public boolean changeBookingToUser(int booking_id, int user_id) {
		try(Connection connect = JDBCUtility.getConnection()){
			
	    	   PreparedStatement pstmt = connect.prepareStatement("update booking set user_id=? where booking_id=?");  
			   pstmt.setInt(1, user_id);
			   pstmt.setInt(2, booking_id);
			   pstmt.executeUpdate();
			   return true;
	    	   
			}
			catch(Exception e) {
				System.out.println("Error while Changing Booking of a user changeBookingToUser(int booking_id, int user_id)"+e);
			}
			
			return false;
	}

	@Override
	public String getAdminPassword(String email) {
		
try(Connection connect = JDBCUtility.getConnection()){
			
			PreparedStatement stmt = connect.prepareStatement("select password from admin where email=?");
			   stmt.setString(1, email);
			   ResultSet set= stmt.executeQuery();
			   while(set.next())  
				   return set.getString(1);
			   
			  
			
		}
		catch(Exception e) {
			System.out.println("Error while getting admin password getAdminPassword(String email)"+e);
		}
		return null;
		
	}

	@Override
	public boolean setAdminPassword(String email, String password) {
		try(Connection connect = JDBCUtility.getConnection()){
			
	    	   PreparedStatement pstmt = connect.prepareStatement("update admin set password=? where email=?");  
			   pstmt.setString(1, password);
			   pstmt.setString(2, email);
			   pstmt.executeUpdate();
			   return true;
	    	   
			}
			catch(Exception e) {
				System.out.println("Error while Setting admin password setAdminPassword(String email, String password)"+e);
			}
			
			return false;
	}

	@Override
	public boolean setAdminEmail(String previous_email, String new_email) {
		try(Connection connect = JDBCUtility.getConnection()){
			
	    	   PreparedStatement pstmt = connect.prepareStatement("update admin set email=? where email=?");  
			   pstmt.setString(1, new_email);
			   pstmt.setString(2, previous_email);
			   pstmt.executeUpdate();
			   return true;
	    	   
			}
			catch(Exception e) {
				System.out.println("Error while Setting admin email setAdminEnail(String previous_email, String new_email)"+e);
			}
			
			return false;
	}

	
	
}
