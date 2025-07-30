package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.SavedAnimeDao;
import org.example.dao.SavedAnimeDaoImpl;
import org.example.model.Anime;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/saved")
public class SavedAnimeServlet extends HttpServlet {
    private final SavedAnimeDao savedDao = new SavedAnimeDaoImpl(); // DAO для saved_anime

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        if (userId == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        try {
            List<Anime> savedList = savedDao.getSavedAnime(userId);
            req.setAttribute("savedList", savedList);
            req.getRequestDispatcher("/WEB-INF/jsp/saved_anime.jsp")
                    .forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException("Error loading saved anime", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        if (userId == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        String action = req.getParameter("action");
        String animeIdParam = req.getParameter("animeId");
        if (animeIdParam == null || (!"add".equals(action) && !"remove".equals(action))) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        int animeId = Integer.parseInt(animeIdParam);
        try {
            if ("add".equals(action)) {
                savedDao.addSavedAnime(userId, animeId);
            } else {
                savedDao.removeSavedAnime(userId, animeId);
            }
            resp.sendRedirect(req.getContextPath() + "/saved");
        } catch (SQLException e) {
            throw new ServletException("Error updating saved anime", e);
        }
    }
}
