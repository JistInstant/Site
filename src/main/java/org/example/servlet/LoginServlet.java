package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.codec.digest.DigestUtils;
import org.example.dao.UserDao;
import org.example.dao.UserDaoImpl;
import org.example.model.User;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
private final UserDao userDao = new UserDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        if (userId != null) {
            // Если уже вошёл — показываем другую страницу
            req.getRequestDispatcher("/WEB-INF/jsp/alreadyLog.jsp").forward(req, resp);
            return;
        }

        // Если не вошёл — показываем форму логина
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username == null || password == null ) {
            req.setAttribute("error", "Введите логие и пароль");
            doGet(req,resp);
            return;
        }
        try {
            User user = userDao.findByUsername(username);
            if (user != null && DigestUtils.sha256Hex(password).equals(user.getPasswordHash())) {
                req.getSession().setAttribute("userId", user.getId());
                resp.sendRedirect(req.getContextPath() + "/saved");
            } else {
                req.setAttribute("error", "Неверный логин или пароль");
                doGet(req, resp);
            }
        } catch (SQLException e) {
            throw new ServletException("Ошибка при попытке входа", e);
        }
    }
}
