package ru.kpfu.itis.nikolaev.net.server;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.stream.Collectors;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.print("This is doGet() method");
        printInfo(req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.print("This is doPost() method");
        printInfo(req);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.print("This is doPut() method");
        printInfo(req);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.print("This is doDelete() method");
        printInfo(req);
    }

    private void printInfo(HttpServletRequest req) throws IOException {
        System.out.println("Parameters:");
        for (Map.Entry<String, String[]> pair : req.getParameterMap().entrySet()) {
            System.out.println(pair.getKey()+"="+ Arrays.toString(pair.getValue()));
        }
        System.out.println("Headers:");
        Enumeration<String> e = req.getHeaderNames();
        System.out.println();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            System.out.println(name + ": " + req.getHeader(name));
        }
        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        System.out.println("Body:");
        System.out.println(requestBody);
    }
}