<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.model.Anime" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Аниме</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
   <jsp:include page="/WEB-INF/jsp/include/header.jsp" />
  <main>
    <h1>Список аниме</h1>
    <div class="anime-grid">
    <c:choose>
      <c:when test="${not empty animeList}">
        <div class="anime-grid">
          <c:forEach var="anime" items="${animeList}">
            <div class="anime-item">
              <a href="${pageContext.request.contextPath}/anime-detail?id=${anime.id}">
                <img src="${anime.imageUrl}" alt="${anime.title}" />
              </a>
              <h3>${anime.title}</h3>
            </div>
          </c:forEach>
        </div>
      </c:when>
      <c:otherwise>
        <p>Нету аниме.</p>
      </c:otherwise>
    </c:choose>
  </main>
  <footer>…</footer>
</body>
</html>
