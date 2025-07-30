<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="include/header.jsp"/>
<head>
    <meta charset="UTF-8">
    <title>Мои сохранные аниме</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<main class="saved-anime-list">
  <h1>Моё сохранённое аниме</h1>
  <c:if test="${empty savedList}">
    <p>У вас нет сохранённых аниме.</p>
  </c:if>
  <c:forEach var="anime" items="${savedList}">
    <div class="anime-item">
      <h2><a href="${pageContext.request.contextPath}/anime-detail?id=${anime.id}">${anime.title}</a></h2>
      <form action="${pageContext.request.contextPath}/saved" method="post">
        <input type="hidden" name="animeId" value="${anime.id}" />
        <input type="hidden" name="action" value="remove" />
        <button type="submit">Удалить из сохранённых</button>
      </form>
    </div>
  </c:forEach>
</main>
