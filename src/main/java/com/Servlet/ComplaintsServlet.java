package com.Servlet;

import com.Dao.ComplaintsDao;
import com.model.Complaints;
import com.model.Users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/Complaints")
public class ComplaintsServlet extends HttpServlet {

    private ComplaintsDao complaintDAO;

    @Override
    public void init() throws ServletException {
        complaintDAO = new ComplaintsDao();
    }

    // Add complaint (POST request)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            request.setAttribute("message", "Please login first to submit a complaint!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        // Logged-in user
        Users user = (Users) session.getAttribute("user");
        int userId = user.getUser_id();

        // Form values
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String status = "PENDING"; // default status in DB enum

        // Add complaint
        boolean success = complaintDAO.addComplaint(userId, title, description, status);

        if (success) {
            session.setAttribute("message", "Complaint submitted successfully!");
        } else {
            session.setAttribute("message", "Failed to submit complaint. Try again!");
        }

        // Redirect to view complaints
        response.sendRedirect("Complaints");
    }

    // View complaints (GET request)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Users user = (Users) session.getAttribute("user");
        String role = user.getRole(); // "ADMIN" or "RESIDENT"
        List<Complaints> complaintsList;

        if ("ADMIN".equalsIgnoreCase(role)) {
            // Admin sees all complaints
            complaintsList = complaintDAO.getAllComplaints();
        } else {
            // Resident sees only their own complaints
            complaintsList = complaintDAO.getComplaintsByUser(user.getUser_id());
        }

        request.setAttribute("complaints", complaintsList);
        request.getRequestDispatcher("viewComplaints.jsp").forward(request, response);
    }
}




