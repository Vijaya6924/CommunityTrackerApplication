<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Complaint</title>
    <style>
        body { font-family: Arial; margin: 30px; background: #f5f5f5; }
        h2 { color: #333; }
        form { width: 400px; background: white; padding: 20px; border-radius: 8px; box-shadow: 0px 2px 6px rgba(0,0,0,0.2); }
        label { display: block; margin-top: 10px; font-weight: bold; }
        input, textarea { width: 100%; padding: 8px; margin-top: 5px; border: 1px solid #ccc; border-radius: 5px; }
        button { margin-top: 15px; background: #4CAF50; color: white; padding: 10px; border: none; border-radius: 5px; cursor: pointer; }
        button:hover { background: #45a049; }
        .message { margin-top: 15px; padding: 10px; background: #e0ffe0; border: 1px solid #b2ffb2; border-radius: 5px; }
    </style>
</head>
<body>
    <h2>Register a New Complaint</h2>

    <%-- Display message from servlet --%>
    <% 
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
        <div class="message"><%= message %></div>
    <% } %>

    <form action="Complaints" method="post">
        <label for="title">Complaint Title:</label>
        <input type="text" name="title" required>

        <label for="description">Description:</label>
        <textarea name="description" rows="4" required></textarea>

        <button type="submit">Submit Complaint</button>
    </form>

    <br>
    <a href="Complaints">View All Complaints</a> <!-- Calls doGet -->
</body>
</html>


