package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cybage.utility.JDBCUtility;

public class CategoryDAOImpl implements CategoryDAO {

	@Override
	public boolean addCategory(String name) {
try(Connection connect = JDBCUtility.getConnection()){
			
			PreparedStatement stmt = connect.prepareStatement("insert into event_category values(?)");
			   stmt.setString(1, name);
			  if (0<stmt.executeUpdate())
				  return true;
			  			
		}
		catch(Exception e) {
			System.out.println("Error while adding category addCategory(String name)"+e);
		}
		return false;
	}

	@Override
	public List<String> getAllCategories() {
try(Connection connect = JDBCUtility.getConnection()){
			List<String> categoryList = new ArrayList<>();
			Statement stmt = connect.createStatement();
			   
			   ResultSet set= stmt.executeQuery("select * from event_category");
			   while(set.next())  
				   categoryList.add(set.getString(1));
			return categoryList;
			
		}
		catch(Exception e) {
			System.out.println("Error while getting AllCategories getAllCategories()"+e);
		}
		return null;
	}

	@Override
	public boolean removeCategory(String category) {
try(Connection connect = JDBCUtility.getConnection()){
			
			PreparedStatement stmt = connect.prepareStatement("delete from event_category where category=?");
			   stmt.setString(1, category);
			   if(0<stmt.executeUpdate())
				   return true;
			   			  
			
		}
		catch(Exception e) {
			System.out.println("Error while removing category removeCategory(String category)"+e);
		}
		return false;
	}

}
