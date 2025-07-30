// ==============================
// File: AnimeDetailServlet.java
// Сервлет “универсальный” — показывает детали обычного и сезонного аниме
// ==============================
package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.dao.AnimeDaoImpl;
import org.example.dao.SavedAnimeDao;
import org.example.dao.SavedAnimeDaoImpl;
import org.example.dao.SeasonAnimeDaoImpl;
import org.example.model.Anime;
import org.example.model.BaseAnime;
import org.example.model.Episode;
import org.example.model.SeasonAnime;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.example.dao.EpisodeDao;
import org.example.dao.EpisodeDaoImpl;


@WebServlet("/anime-detail")             // URL, на который ведут ВСЕ ссылки в шаблонах
public class AnimeDetailServlet extends HttpServlet {
    private final AnimeDaoImpl animeDao = new AnimeDaoImpl();
    private final SeasonAnimeDaoImpl seasonDao = new SeasonAnimeDaoImpl();
    private final SavedAnimeDao savedDao = new SavedAnimeDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idParam = req.getParameter("id");
        String type = req.getParameter("type"); // "season" или null
        if (idParam == null) {
            resp.sendError(400, "Missing id");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            resp.sendError(400, "Invalid id");
            return;
        }

        // 1) Загружаем объект из нужного DAO
        BaseAnime anime = "season".equals(type) ? seasonDao.getById(id) : animeDao.getById(id);

        if (anime == null) {
            resp.sendError(404);
            return;
        }

        if (anime instanceof SeasonAnime) {
            EpisodeDao episodeDao = new EpisodeDaoImpl();
            List<Episode> episodes = episodeDao.getEpisodesBySeasonAnimeId(anime.getId());
            req.setAttribute("episodes", episodes);
        }
        // 3) Проверка, сохранял ли пользователь это аниме
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        boolean isSaved = false;
        if (userId != null) {
            try {
                isSaved = savedDao.isSavedAnime(userId, anime.getId());
            } catch (SQLException e) {
                throw new RuntimeException("Error checking saved status for animeId=" + anime.getId(), e);
            }
        }

        req.setAttribute("anime", anime);
        req.setAttribute("isSaved", isSaved);
        req.getRequestDispatcher("/WEB-INF/jsp/anime-detail.jsp").forward(req, resp);
    }
}