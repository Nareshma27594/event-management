package com.cybage.bean;

import java.util.HashSet;
import java.util.Set;

public class EventCategory {

	private Set<String> categorySet = new HashSet<>();
	public boolean removeCategory(String category) {
		
		return this.categorySet.remove(category);
		
	}
	
	public void addCategory(String category) {
		 this.categorySet.add(category);
	}
	
	public Set<String> getCategories() {
		return this.categorySet;
	}
	
}
