<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.model.SeasonAnime" %>
<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <title>Favoranime</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <script src="${pageContext.request.contextPath}/js/main.js"></script>
</head>
<body>
  <!-- 1) Липкий хедер -->
 <jsp:include page="/WEB-INF/jsp/include/header.jsp" />
  <main>
    <!-- 2) Карусель “Большая тройка” -->
    <section class="highlight">
      <div class="carousel">
        <a id="carousel-link" href="#">
          <img id="carousel-image" src="" alt="Большая тройка" />
          <div class="highlight-title">Большая тройка</div>
        </a>
      </div>
    </section>

    <!-- 3) Сетка сезонных аниме -->
    <section class="season-grid">
      <c:forEach var="season" items="${seasonList}">
        <div class="season-item">
          <a href="${pageContext.request.contextPath}/anime-detail?id=${season.id}&amp;type=season">
            <img src="${season.imageUrl}" alt="${season.title}" />
          </a>
          <p class="caption">${season.title}</p>
        </div>
      </c:forEach>
    </section>
  </main>
</body>
</html>
