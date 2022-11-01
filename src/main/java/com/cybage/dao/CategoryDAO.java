package com.cybage.dao;

import java.util.List;

public interface CategoryDAO {
	public boolean addCategory(String name);
	   public List<String> getAllCategories();
	   public boolean removeCategory(String name);
	   public boolean updateCategory(String name, String nametobeupdated);
}
