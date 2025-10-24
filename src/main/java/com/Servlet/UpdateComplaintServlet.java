package com.Servlet;

import java.io.IOException;

import com.Dao.ComplaintsDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateComplaint")
public class UpdateComplaintServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ComplaintsDao dao = new ComplaintsDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int complaintId = Integer.parseInt(request.getParameter("complaintId"));
            String status = request.getParameter("status");

            // Call DAO method
            boolean updated = dao.updateComplaintStatus(complaintId, status);

            if(updated) {
                // After update, reload complaints list
                response.sendRedirect("admin"); // AdminServlet will fetch and forward to dashboard
            } else {
                response.getWriter().println("Update failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}



