package com.Servlet;

import com.Dao.UserDao;
import com.model.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    
    private UserDao userDAO;

    public void init() {
        userDAO = new UserDao();  // assign to class variable
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        Users user = userDAO.login(email, password, role);

        if (user != null) {
            HttpSession session = request.getSession();
            // Store the full user object
            session.setAttribute("user", user);
            //  Store userId separately (important for ComplaintsServlet)
            session.setAttribute("userId", user.getUser_id());

            if ("admin".equalsIgnoreCase(user.getRole())) {
                response.sendRedirect("admin");
            } else {
                response.sendRedirect("resident_dashboard.jsp");
            }
        } else {
            request.setAttribute("errorMessage", "Invalid Email/Password/Role");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}


