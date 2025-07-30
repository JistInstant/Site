<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="include/header.jsp" />
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Аккаунт</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<main class="already-logged">
  <h1>Вы уже авторизованы</h1>
  <p>Логин: <strong>${user.username}</strong></p>
  <p>Email: <strong>${user.email}</strong></p>
  <p>ID: <strong>${user.id}</strong></p>
  <a href="${pageContext.request.contextPath}/saved">Перейти к сохранённому</a>
</main>
