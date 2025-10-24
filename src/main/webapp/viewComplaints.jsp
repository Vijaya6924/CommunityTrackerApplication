<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Complaints" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Complaints</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background: #f9f9f9;
        }
        h2 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
            box-shadow: 0px 2px 6px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background: #f2f2f2;
        }
        .btn {
            background: #2196F3;
            color: white;
            padding: 6px 12px;
            border-radius: 5px;
            text-decoration: none;
        }
        .btn:hover {
            background: #0b7dda;
        }
    </style>
</head>
<body>
    <h2>All Complaints</h2>

    <%
        List<Complaints> complaints = (List<Complaints>) request.getAttribute("complaints");
        if (complaints != null && !complaints.isEmpty()) {
    %>
        <table>
            <tr>
                <th>ID</th>
                <th>User ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Status</th>
                
            </tr>
            <%
                for (Complaints c : complaints) {
            %>
            <tr>
                <td><%= c.getComplaint_id() %></td>
                <td><%= c.getUser_id() %></td>
                <td><%= c.getTitle() %></td>
                <td><%= c.getDescription() %></td>
                <td><%= c.getStatus() %></td>
                
            </tr>
            <% } %>
        </table>
    <%
        } else {
    %>
        <p>No complaints available.</p>
    <%
        }
    %>

    <br>
    <a href="Complaint.jsp">➕ Add New Complaint</a>
</body>
</html>
