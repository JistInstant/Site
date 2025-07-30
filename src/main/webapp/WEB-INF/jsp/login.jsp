<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Вход</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <jsp:include page="include/header.jsp" />

    <main class="login-page">
        <h1>Вход</h1>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <c:if test="${not empty error}">
                <p class="error">${error}</p>
            </c:if>

            <label for="username">Логин:</label>
            <input type="text" name="username" id="username" autocomplete="username" required>

            <label for="password">Пароль:</label>
            <input type="password" name="password" id="password" autocomplete="current-password" required>

            <button type="submit">Войти</button>
        </form>
    </main>
</body>
</html>