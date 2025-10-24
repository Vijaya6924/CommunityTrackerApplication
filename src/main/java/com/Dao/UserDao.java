package com.Dao;

import com.model.Users;
import com.utils.DBConnection;
import com.utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    // Register new user
    public boolean registerUser(Users user) {
        boolean rowInserted = false;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(Constants.INSERT_USER)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());

            rowInserted = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowInserted;
    }

    // Login user (email + password + role)
    public Users login(String email, String password, String role) {
        Users user = null;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(Constants.SELECT_USER_BY_EMAIL_PASSWORD)) {

            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, role);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new Users();
                user.setUser_id(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    // Get user by ID
    public Users getUserById(int userId) {
        Users user = null;
        //String query = "SELECT * FROM users WHERE user_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(Constants.GET_USER_BY_ID)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new Users();
                user.setUser_id(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    // Get all users (admin)
    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<>();
        //String query = "SELECT * FROM users";
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(Constants.GET_ALL_USERS)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Users user = new Users();
                user.setUser_id(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

                users.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}







