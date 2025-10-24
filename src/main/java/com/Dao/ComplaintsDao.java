package com.Dao;

import com.model.Complaints;
import com.utils.DBConnection;
import com.utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComplaintsDao {

    // Add a complaint
    public boolean addComplaint(int userId, String title, String description, String status) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(Constants.INSERT_COMPLAINT)) {

            ps.setInt(1, userId);
            ps.setString(2, title);
            ps.setString(3, description);
            ps.setString(4, status);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get all complaints (for admin)
    public List<Complaints> getAllComplaints() {
        List<Complaints> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(Constants.SELECT_ALL_COMPLAINTS);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Complaints c = new Complaints();
                c.setComplaint_id(rs.getInt("complaint_id"));
                c.setUser_id(rs.getInt("user_id"));
                c.setTitle(rs.getString("title"));
                c.setDescription(rs.getString("description"));
                c.setStatus(rs.getString("status"));
                c.setCreated_at(rs.getTimestamp("created_at"));
                c.setUpdated_at(rs.getTimestamp("updated_at"));
                list.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

 // Get complaints by specific user (for resident)
    public List<Complaints> getComplaintsByUser(int userId) {
        List<Complaints> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(Constants.SELECT_COMPLAINTS_BY_USER)) {

            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Complaints c = new Complaints();
                    c.setComplaint_id(rs.getInt("complaint_id"));
                    c.setUser_id(rs.getInt("user_id"));
                    c.setTitle(rs.getString("title"));
                    c.setDescription(rs.getString("description"));
                    c.setStatus(rs.getString("status"));
                    c.setCreated_at(rs.getTimestamp("created_at"));
                    c.setUpdated_at(rs.getTimestamp("updated_at"));
                    list.add(c);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Update complaint status (for admin)
    public boolean updateComplaintStatus(int complaintId, String status) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(Constants.UPDATE_COMPLAINT_STATUS)) {

            ps.setString(1, status);
            ps.setInt(2, complaintId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}



