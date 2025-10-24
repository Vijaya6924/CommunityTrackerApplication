package com.utils;

public class Constants {
    
    // User table queries
    public static final String INSERT_USER = 
        "INSERT INTO users(name, email, password, role) VALUES (?, ?, ?, ?)";
    public static final String SELECT_USER_BY_EMAIL_PASSWORD = 
        "SELECT * FROM users WHERE email = ? AND password = ? AND role = ?";
    
    // Complaint table queries
    public static final String INSERT_COMPLAINT = 
        "INSERT INTO complaints(user_id, title, description, status) VALUES (?, ?, ?, ?)";
    public static final String SELECT_ALL_COMPLAINTS = 
        "SELECT * FROM complaints";
    
    // Complaint history queries
    public static final String INSERT_COMPLAINT_HISTORY = 
        "INSERT INTO complaint_history(complaint_id, action, action_date) VALUES (?, ?, ?)";
    public static final String SELECT_HISTORY_BY_COMPLAINT = 
        "SELECT * FROM complaint_history WHERE complaint_id = ?";
    
    // Assignment queries
    public static final String INSERT_ASSIGNMENT = 
        "INSERT INTO assignments(complaint_id, assigned_to, assigned_date) VALUES (?, ?, ?)";
    public static final String SELECT_ASSIGNMENTS = 
        "SELECT * FROM assignments WHERE complaint_id = ?";
    public static final String UPDATE_COMPLAINT_STATUS =
    	    "UPDATE complaints SET status=?, updated_at=CURRENT_TIMESTAMP WHERE complaint_id=?";
    
    public static final String SELECT_COMPLAINTS_BY_USER =
            "SELECT * FROM complaints WHERE user_id = ? ORDER BY created_at DESC";
    
    
    public static final String GET_USER_BY_ID=
    		"SELECT * FROM users WHERE user_id = ?";
    
    public static final String GET_ALL_USERS=
    		"SELECT * FROM users";
}



