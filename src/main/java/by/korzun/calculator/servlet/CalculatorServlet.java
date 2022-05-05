package by.korzun.calculator.servlet;

import org.apache.logging.log4j.util.Strings;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "calc", value = "/calc")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter1 = req.getParameter("num1");
        String parameter2 = req.getParameter("num2");
        if(Strings.isNotEmpty(parameter1) && Strings.isNotEmpty(parameter2)) {
            double num1 = Double.parseDouble(parameter1);
            double num2 = Double.parseDouble(parameter2);
            String operation = req.getParameter("operation");
            switch (operation) {
                case "sum":
                    req.setAttribute("result", num1 + num2);
                    break;
            }
        }
        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }
}
