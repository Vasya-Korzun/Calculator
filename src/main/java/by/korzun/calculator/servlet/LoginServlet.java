package by.korzun.calculator.servlet;

import by.korzun.calculator.exceptions.InvalidPasswordException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import by.korzun.calculator.dao.UserDao;
import by.korzun.calculator.entity.User;
import by.korzun.calculator.exceptions.InvalidNameException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    private final UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            User user = new User(req.getParameter("userName"), req.getParameter("password"));
            if (userDao.userExist(user)) {
                Cookie cookie = new Cookie("Uaser", "true");
                cookie.setMaxAge(600);
                resp.addCookie(cookie);
                resp.sendRedirect("/pages/calc.jsp");
            } else {
                Cookie cookie = new Cookie("Uaser", "false");
                resp.addCookie(cookie);
                resp.sendRedirect("/pages/loginFailed.jsp");
            }
        }catch (InvalidNameException | InvalidPasswordException e) {
            logger.error(e.getMessage(), e);
        }

    }
}
