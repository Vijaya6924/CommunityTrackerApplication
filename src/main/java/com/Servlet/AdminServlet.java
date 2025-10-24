package com.Servlet;

import com.Dao.ComplaintsDao;
import com.model.Complaints;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ComplaintsDao dao = new ComplaintsDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //  Get all complaints as List<Complaints>
        List<Complaints> complaintsList = dao.getAllComplaints();

        // Set attribute for JSP
        request.setAttribute("complaints", complaintsList);

        // Forward to admin dashboard JSP
        RequestDispatcher rd = request.getRequestDispatcher("adminDashboard.jsp");
        rd.forward(request, response);
    }
}


