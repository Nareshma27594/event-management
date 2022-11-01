package com.cybage.services;

import java.util.List;

import com.cybage.dao.CategoryDAO;
import com.cybage.dao.CategoryDAOImpl;

public class EventCategoryServiceImpl implements EventCategoryService{
    public static CategoryDAO categoryDao = new CategoryDAOImpl();
	@Override
	public boolean addCategory(String name) {
	    
		return categoryDao.addCategory(name);
	}

	@Override
	public List<String> getAllCategories() {
		
		return categoryDao.getAllCategories();
	}

	@Override
	public boolean removeCategory(String name) {
		
		return categoryDao.removeCategory(name);
	}

	@Override
	public boolean updateCategory(String category, String categoryToBeUpdated) {
		
		return categoryDao.updateCategory(category, categoryToBeUpdated);
	}

}
