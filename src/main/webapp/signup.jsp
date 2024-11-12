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
        background-color: #f4f4f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    h4 {
        text-align: center;
        color: #ffffff;
    }

    form {
        background-color: #5e5e5d;
        padding: 8px 18px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        width: 380px;
        color: white;
    }

    label {
        font-weight: bold;
        color: white;
    }

    input[type="text"],
    input[type="email"],
    input[type="tel"],
    input[type="date"],
    input[type="password"],
    textarea {
        width: 100%;
        padding: 8px;
        margin: 8px 0 10px 0;
        border: 1px solid #ddd;
        border-radius: 5px;
        box-sizing: border-box;
    }

    input[type="radio"] {
        margin-right: 8px;
    }

    textarea {
        resize: vertical;
    }

    .radio-group {
        display: flex;
        justify-content: space-between;
    }

    input[type="submit"] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 10px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>

<form action="AddStudentServlet" method="post">
    <h4>Student Personal Information Form</h4> 
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" required>

    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" required>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$" title="Please enter a valid email address">

    <label for="number">Phone Number:</label>
    <input type="tel" id="number" name="number" required pattern="[0-9]{10}" title="Please enter a 10-digit phone number">

    <label for="gender">Gender:</label>
    <div class="radio-group">
        <label><input type="radio" id="male" name="gender" value="male" required> Male</label>
        <label><input type="radio" id="female" name="gender" value="female" required> Female</label>
        <label><input type="radio" id="other" name="gender" value="other" required> Other</label>
    </div>

    <label for="address">Address:</label>
    <textarea id="address" name="address" rows="4" required></textarea>

    <label for="birthdate">Birthdate:</label>
    <input type="date" id="birthdate" name="birthdate" required>

    <label for="aadharcard">Aadhar Card Number:</label>
    <input type="text" id="aadharcard" name="aadharcard" required pattern="[0-9]{12}" title="Please enter a 12-digit Aadhar card number">

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required  title="Password must be at least 8 characters long">

    <input type="submit" value="Submit">
</form>

</body>
</html>