<%-- ========================= --%>
<%-- File: anime-detail.jsp    --%>
<%-- Шаблон страницы с деталями выбранного аниме --%>
<%-- ========================= --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <title>
    <c:choose>
      <c:when test="${not empty anime}">
        ${anime.title}    <%-- выводим getTitle() --%>
      </c:when>
      <c:otherwise>Аниме не найдено</c:otherwise>
    </c:choose>
  </title>
  <!-- Общие стили -->
  <link rel="stylesheet"
        href="${pageContext.request.contextPath}/css/style.css" />
  <!-- Стили для страницы детализации -->
  <link rel="stylesheet"
        href="${pageContext.request.contextPath}/css/anime-detail.css" />
</head>
<body>
  <jsp:include page="/WEB-INF/jsp/include/header.jsp" />
  </header>

  <main>
    <%-- Блок с деталями, если anime != null --%>
    <c:if test="${not empty anime}">
      <section class="anime-detail">
        <!-- Постер -->
        <img class="anime-detail-poster"
             src="${anime.imageUrl}"
             alt="Постер ${anime.title}" />
        <!-- Название -->
        <h1>${anime.title}</h1>
        <!-- Описание и доп. поля -->
        <p>${anime.description}</p>
        <p><strong>Жанр:</strong> ${anime.genre}</p>
        <p><strong>Рейтинг:</strong> ${anime.rating}</p>
        <c:forEach var="ep" items="${episodes}">
          <h3>${ep.title}</h3>
          <iframe
            width="640"
            height="360"
            src="${ep.videoUrl}"
            frameborder="0"
            allowfullscreen>
          </iframe>
        </c:forEach>
        <!-- Ссылка назад -->
        <p>
          <a href="${pageContext.request.contextPath}/anime-catalog">
            ← Вернуться к списку аниме
          </a>
        </p>
      </section>
    </c:if>

    <%-- Блок, если anime == null --%>
    <c:if test="${empty anime}">
      <section class="anime-detail-missing">
        <p>Извините, такое аниме не найдено.</p>
        <p><a href="${pageContext.request.contextPath}/anime-catalog">Вернуться к списку</a></p>
      </section>
    </c:if>
  </main>

</body>
</html>
