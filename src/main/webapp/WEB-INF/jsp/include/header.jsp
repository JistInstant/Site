<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- File: WEB-INF/jsp/include/header.jsp --%>

<header class="site-header">
  <div class="logo">
    <a href="${pageContext.request.contextPath}/favoranime">favoranime</a>
  </div>

  <nav class="main-nav">

     <!-- Ссылка на страницу топ-100 -->
     <a href="${pageContext.request.contextPath}/top100">Топ 100</a>

     <!-- Уже была -->
     <a href="${pageContext.request.contextPath}/anime-catalog">Каталог аниме</a>
  </nav>

  <!-- Вот этот блок точно должен быть у вас -->
  <div class="nav-icons">
    <a href="${pageContext.request.contextPath}/saved" title="Сохранённые">
      <img
        src="https://res.cloudinary.com/dptqp3lut/image/upload/v1750070211/bookmark_zh4yfz.webp"
        alt="saved" />
    </a>
    <a href="${pageContext.request.contextPath}/login" title="Войти">
      <img
        src="https://res.cloudinary.com/dptqp3lut/image/upload/v1750070211/icon_cjikso.png"
        alt="login" />
    </a>
  </div>
</header>
