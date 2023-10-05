package ru.kpfu.itis.nikolaev.net.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "calculatorServlet", urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("index.ftl");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получить значения чисел из параметров запроса
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");

        // Преобразовать значения в числа (предполагается валидация)
        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);

        // Вычислить сумму
        int sum = num1 + num2;

        // Установить результат в атрибут запроса
        request.setAttribute("result", sum);

        // Перенаправить на страницу с результатом
        request.getRequestDispatcher("/result.ftl").forward(request,response);
    }
}
