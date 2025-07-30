package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.SeasonAnimeDao;
import org.example.dao.SeasonAnimeDaoImpl;
import org.example.model.SeasonAnime;

import java.io.IOException;
import java.util.List;

@WebServlet("/favoranime")
public class FavoranimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<SeasonAnime> list = new SeasonAnimeDaoImpl().getAll();
        req.setAttribute("seasonList", list);
        req.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(req, resp);
    }
}
