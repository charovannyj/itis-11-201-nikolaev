package ru.kpfu.itis.nikolaev.net.server;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "resultServlet", urlPatterns = "/resultservlet")
public class ResultServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.sendRedirect("result.ftl");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num3Str = request.getParameter("num3");
        String num4Str = request.getParameter("num4");

        // Преобразовать значения в числа (предполагается валидация)
        int num3 = Integer.parseInt(num3Str);
        int num4 = Integer.parseInt(num4Str);

        // Вычислить сумму
        int sum = num3 + num4;

        // Установить результат в атрибут запроса
        request.setAttribute("result", sum);

        // Перенаправить на страницу с результатом
        request.getRequestDispatcher("/resultt.ftl").forward(request, response);
    }
}
