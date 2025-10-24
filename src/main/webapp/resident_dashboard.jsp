<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.model.Users" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resident Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f9;
            margin: 0;
            padding: 0;
        }
        .navbar {
            background-color: #2c3e50;
            padding: 15px;
            color: white;
            text-align: right;
        }
        .navbar a {
            color: white;
            margin-left: 20px;
            text-decoration: none;
            font-weight: bold;
        }
        .container {
            margin: 40px auto;
            width: 80%;
            background: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.2);
        }
        h2 {
            color: #2c3e50;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            margin: 15px 10px 0 0;
            border: none;
            border-radius: 5px;
            background-color: #3498db;
            color: white;
            font-size: 16px;
            cursor: pointer;
            text-decoration: none;
        }
        .btn:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>

<%
    // Get user from session
    HttpSession sess = request.getSession(false);
    Users user = null;
    if (sess != null) {
        user = (Users) sess.getAttribute("user");
    }
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<div class="navbar">
    Welcome, <%= user.getName() %> |
    <a href="logout.jsp">Logout</a>
</div>

<div class="container">
    <h2>Resident Dashboard</h2>
    <p>Hello <strong><%= user.getName() %></strong>, you are logged in as <b><%= user.getRole() %></b>.</p>

    <!-- Complaint Button -->
    <form action="Complaint.jsp" method="get">
        <button type="submit" class="btn">Raise Complaint</button>
    </form>

    <!-- Future Options -->
    <a href="ViewComplaints" class="btn">View My Complaints</a>
</div>

</body>
</html>
