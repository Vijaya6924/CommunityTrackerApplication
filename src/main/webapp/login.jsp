<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
    body {
        background-color: skyblue;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        font-family: Arial, sans-serif;
        margin: 0;
    }

    .login-container {
        background-color: white;
        padding: 30px 40px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.2);
        text-align: center;
    }

    input[type="email"], input[type="password"], select {
        width: 100%;
        padding: 8px;
        margin: 5px 0 15px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

    a {
        color: #007BFF;
        text-decoration: none;
    }

    a:hover {
        text-decoration: underline;
    }

    p {
        margin: 10px 0;
    }
</style>
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>

        <form action="Login" method="post">
            Email: <input type="email" name="email" placeholder="Enter email" required><br>
            Password: <input type="password" name="password" placeholder="Enter password" required><br>
            
            Role:
            <select name="role" required>
                <option value="resident">Resident</option>
                <option value="admin">Admin</option>
            </select><br>

            <input type="submit" value="Login">
        </form>

        <% 
            String msg = request.getParameter("message");
            if (msg != null) {
        %>
            <p style="color:green; font-weight:bold;"><%= msg %></p>
        <% } %>

        <% String errorMessage = (String) request.getAttribute("errorMessage");
           if (errorMessage != null) { %>
            <p style="color:red;"><%= errorMessage %></p>
        <% } %>

        <p>Are you a new user? 
           <a href="Signup.jsp">Sign Up</a>
        </p>
    </div>
</body>
</html>

