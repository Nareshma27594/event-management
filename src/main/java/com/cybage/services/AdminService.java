package com.cybage.services;

public interface AdminService {
        public String getPassword(String email);
        public boolean setPassword(String email,String password);
        public boolean setAdminEmail(String previous_email, String new_email);
}
