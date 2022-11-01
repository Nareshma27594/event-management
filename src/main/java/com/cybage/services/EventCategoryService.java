package com.cybage.services;

import java.util.List;

public interface EventCategoryService {
   public boolean addCategory(String name);
   public List<String> getAllCategories();
   public boolean removeCategory(String name);
}
