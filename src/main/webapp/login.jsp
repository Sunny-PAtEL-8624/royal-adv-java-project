<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="style.css">
</head>
<style>
/* ... existing CSS styles ... */

.error-message {
    color: red;
    font-size: 12px;
    margin-top: 5px;
}
.login-container {
    border: 1px solid #ccc;
    padding: 20px;
    width: 300px;
    margin: 0 auto;
}

input[type=email], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    background-color: #45a049;
}
</style>
<% 
    String emailError = (String)request.getAttribute("emailError");
    String passwordError = (String)request.getAttribute("passwordError");
%>

<body>
    <div class="login-container">
        <h1>Login</h1>
        <form action="LoginStudentServlet">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            <% if (emailError != null) { %>
                <p class="error-message"><%= emailError %></p>
            <% } %>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <% if (passwordError != null) { %>
                <p class="error-message"><%= passwordError %></p>
            <% } %>

            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>