<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>Register</head>
<body>
<form method="post">
    <div>
        <input type="text" name="firstName" placeholder="First Name"/> </label>
    </div>
    <div>
        <input type="text" name="lastName" placeholder="Last Name"/> </label>
    </div>
    <div>
        <input type="email" name="email" placeholder="Email"/> </label>
    </div>
    <div>
        <input type="password" name="password" placeholder="Password"/>
    </div>
    <button type="submit" value="Register">Register</button>
</form>
</body>
</html>