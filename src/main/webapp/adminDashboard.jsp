<%@ page import="java.util.*, com.model.Complaints,com.Dao.ComplaintsDao,com.Servlet.UpdateComplaintServlet" %>
<%
    List<Complaints> complaints = (List<Complaints>) request.getAttribute("complaints");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
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
            width: 95%;
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
            padding: 6px 12px;
            margin: 2px 0;
            border: none;
            border-radius: 5px;
            background-color: #3498db;
            color: white;
            font-size: 14px;
            cursor: pointer;
            text-decoration: none;
        }
        .btn:hover {
            background-color: #2980b9;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #3498db;
            color: white;
        }
        select {
            padding: 5px;
        }
    </style>
</head>
<body>
    <div class="navbar">
        Admin Panel |
        <a href="logout.jsp">Logout</a>
    </div>

    <div class="container">
        <h2>All Complaints</h2>

        <table>
            <tr>
                <th>ID</th>
                <th>User ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Status</th>
                <th>Created At</th>
                <th>Updated At</th>
                <th>Action</th>
            </tr>

            <%
                if (complaints != null) {
                    for (Complaints c : complaints) {
            %>
            <tr>
                <td><%= c.getComplaint_id() %></td>
                <td><%= c.getUser_id() %></td>
                <td><%= c.getTitle() %></td>
                <td><%= c.getDescription() %></td>
                <td><%= c.getStatus() %></td>
                <td><%= c.getCreated_at() %></td>
                <td><%= c.getUpdated_at()%></td>
                <td>
                    <form action="updateComplaint" method="post">
                        <input type="hidden" name="complaintId" value="<%= c.getComplaint_id()%>">
                        <select name="status">
    <option value="PENDING" <%= "PENDING".equals(c.getStatus()) ? "selected" : "" %>>Pending</option>
    <option value="IN_PROGRESS" <%= "IN_PROGRESS".equals(c.getStatus()) ? "selected" : "" %>>In Progress</option>
    <option value="RESOLVED" <%= "RESOLVED".equals(c.getStatus()) ? "selected" : "" %>>Resolved</option>
</select>

                        <input type="submit" class="btn" value="Update">
                    </form>
                </td>
            </tr>
            <%      }
                }
            %>
        </table>
        
    </div>
</body>
</html>
