package ru.kpfu.itis.nikolaev.net.server;

import netscape.javascript.JSObject;
import org.json.JSONObject;
import ru.kpfu.itis.nikolaev.net.client.HttpClient;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "cityServlet", urlPatterns = "/city")
public class CityServlet extends HttpServlet {
    String weather;
    String API = "630038a3144129b2eca8f66b4ec7ec82";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("city.ftl").forward(req,resp);
        //resp.sendRedirect("city.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city = req.getParameter("city");
        weather = new HttpClient().get("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API, null);
        HttpSession session = req.getSession();
        setAttributesForSession(session);
        resp.sendRedirect("weather.ftl");
    }

    private void setAttributesForSession(HttpSession httpSession) {
        JSONObject json = new JSONObject(weather);
        httpSession.setAttribute("temperature", json.getJSONObject("weather").getBigDecimal("temp"));
        httpSession.setAttribute("humidity", json.getJSONObject("main").getBigDecimal("humidity"));
        httpSession.setAttribute("description", json.getJSONArray("weather").getJSONObject(0).getString("description"));
    }
}
