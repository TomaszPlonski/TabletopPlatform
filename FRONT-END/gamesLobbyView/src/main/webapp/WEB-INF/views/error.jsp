<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>Expect an exception...</head>
<body>
<c:choose>
    <c:when test="${empty error.message}">
       Something gone wrong...
    </c:when>
    <c:otherwise>
        ${error.message}
    </c:otherwise>
</c:choose>
</body>
</html>