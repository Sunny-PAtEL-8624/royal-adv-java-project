<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Personal Information Form</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f7f7f7;
        margin: 0;
        padding: 0;
    }

    form {
        max-width: 600px;
        margin: 30px auto;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
    }

    h4 {
        text-align: center;
        margin-bottom: 20px;
    }

    label {
        display: block;
        margin: 10px 0 5px;
        font-weight: bold;
    }

    input, textarea {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 14px;
    }

    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
        font-size: 16px;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

    .error {
        color: red;
        font-size: 12px;
        margin-top: -10px;
        margin-bottom: 10px;
        display: block;
    }

    .radio-group label {
        display: inline-block;
        margin-right: 15px;
        font-weight: normal;
    }
</style>

</head>
<% 
String addressError = (String)request.getAttribute("addressError");
    String emailError = (String)request.getAttribute("emailError");
    String passwordError = (String)request.getAttribute("passwordError");
    String firstNameError = (String)request.getAttribute("firstNameError");
    String lastNameError = (String)request.getAttribute("lastNameError");
    String phoneNumberError = (String)request.getAttribute("phoneNumberError");
    String genderError = (String)request.getAttribute("genderError");
    String birthdateError = (String)request.getAttribute("birthdateError");
    String aadharCardError = (String)request.getAttribute("aadharCardError");
    String emailExistsError = (String)request.getAttribute("emailExistsError");
    String aadharExistsError = (String)request.getAttribute("aadharExistsError");
%>
<body>

<form action="AddStudentServlet" method="post">
    <h4>Student Personal Information Form</h4> 

    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName">
    <% if (firstNameError != null) { %>
        <span class="error"><%= firstNameError %></span>
    <% } %>

    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName">
    <% if (lastNameError != null) { %>
        <span class="error"><%= lastNameError %></span>
    <% } %>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email">
    <% if (emailError != null) { %>
        <span class="error"><%= emailError %></span>
    <% } %>
    <% if (emailExistsError != null) { %>
        <span class="error"><%= emailExistsError %></span>
    <% } %>

    <label for="number">Phone Number:</label>
    <input type="tel" id="number" name="number">
    <% if (phoneNumberError != null) { %>
        <span class="error"><%= phoneNumberError %></span>
    <% } %>

    <label for="gender">Gender:</label>
    <div class="radio-group">
        <label><input type="radio" id="male" name="gender" value="male"> Male</label>
        <label><input type="radio" id="female" name="gender" value="female"> Female</label>
        <label><input type="radio" id="other" name="gender" value="other"> Other</label>
    </div>
    <% if (genderError != null) { %>
        <span class="error"><%= genderError %></span>
    <% } %>

    <label for="address">Address:</label>
    <textarea id="address" name="address" rows="4"></textarea>
    <% if (addressError != null) { %>
        <span class="error"><%= addressError %></span>
    <% } %>

    <label for="birthdate">Birthdate:</label>
    <input type="date" id="birthdate" name="birthdate">
    <% if (birthdateError != null) { %>
        <span class="error"><%= birthdateError %></span>
    <% } %>

    <label for="aadharcard">Aadhar Card Number:</label>
    <input type="text" id="aadharcard" name="aadharcard">
    <% if (aadharCardError != null) { %>
        <span class="error"><%= aadharCardError %></span>
    <% } %>
    <% if (aadharExistsError != null) { %>
        <span class="error"><%= aadharExistsError %></span>
    <% } %>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password">
    <% if (passwordError != null) { %>
        <span class="error"><%= passwordError %></span>
    <% } %>

    <input type="submit" value="Submit">
</form>

</body>
</html>
