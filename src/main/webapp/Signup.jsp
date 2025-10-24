<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup Page</title>
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

    .signup-container {
        background-color: white;
        padding: 30px 40px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.2);
        text-align: center;
        width: 300px;
    }

    input[type="text"], input[type="email"], 
    input[type="password"], input[type="number"], 
    select {
        width: 100%;
        padding: 8px;
        margin: 8px 0 15px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    input[type="submit"] {
        background-color: #007BFF;
        color: white;
        padding: 10px;
        width: 100%;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

    a {
        color: #007BFF;
        text-decoration: none;
    }

    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <div class="signup-container">
        <h2>Sign Up</h2>
        <form action="Register" method="post">
            Name: <input type="text" name="name" placeholder="Enter Name" required><br>
            Email: <input type="email" name="email" placeholder="Enter Email" required><br>
            Password: <input type="password" name="password" placeholder="Enter Password" required><br>
            Phone: <input type="number" name="phoneNumber" placeholder="Enter Phone No" required><br>
            
            Role:
            <select name="role" required>
                <option value="resident">Resident</option>
                <option value="admin">Admin</option>
            </select><br>

            <input type="submit" value="Sign Up">
        </form>

        <p>Already have an account? 
            <a href="login.jsp">Login</a>
        </p>
    </div>
</body>
</html>
