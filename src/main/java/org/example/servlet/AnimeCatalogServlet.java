package org.example.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.AnimeDao;
import org.example.dao.AnimeDaoImpl;
import org.example.model.Anime;

import java.io.IOException;
import java.util.List;

@WebServlet("/anime-catalog")
public class AnimeCatalogServlet extends HttpServlet {
    private final AnimeDao dao = new AnimeDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Anime> list = dao.getAll();           // читаем из БД
        req.setAttribute("animeList", list);      // кладём в атрибут
        // → форвардим на anime-catalog.jsp, а не на anime.html
        req.getRequestDispatcher("/WEB-INF/jsp/anime-catalog.jsp").forward(req, resp);
    }
}

