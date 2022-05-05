package by.korzun.calculator.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import by.korzun.calculator.dao.UserDao;
import by.korzun.calculator.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registration", value = "/registration")
public class RegistrationServlet extends HttpServlet {
    private final static Logger logger = LoggerFactory.getLogger(RegistrationServlet.class);

    private final UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = new User(req.getParameter("userName"), req.getParameter("password"));
            if (userDao.saveUser(user)) {
                Cookie cookie = new Cookie("Uaser", "true");
                cookie.setMaxAge(600);
                resp.addCookie(cookie);
                resp.sendRedirect("/calc");
            } else {
                resp.sendRedirect("/registration");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }
}
