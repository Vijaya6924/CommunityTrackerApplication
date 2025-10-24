package com.Servlet;

import com.Dao.ComplaintsDao;
import com.model.Complaints;
import com.model.Users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ViewComplaints")
public class ViewComplaintsServlet extends HttpServlet {

    private ComplaintsDao complaintDAO;

    @Override
    public void init() throws ServletException {
        complaintDAO = new ComplaintsDao();
    }

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
        List<Complaints> complaints;

        if ("ADMIN".equalsIgnoreCase(role)) {
            // Admin sees all complaints
            complaints = complaintDAO.getAllComplaints();
        } else {
            // Resident sees only their own complaints
            complaints = complaintDAO.getComplaintsByUser(user.getUser_id());
        }

        request.setAttribute("complaints", complaints);
        request.getRequestDispatcher("viewComplaints.jsp").forward(request, response);
    }
}



