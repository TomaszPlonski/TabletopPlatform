<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head></head>
<body>
<table>
    <thead>
    <tr>
        <th>Game name</th>
        <th>Min players</th>
        <th>Max players</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allGames}" var="game">
        <tr>
            <td>${game.name}</td>
            <td>${game.minNumberOfPlayers}</td>
            <td>${game.maxNumberOfPlayers}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>