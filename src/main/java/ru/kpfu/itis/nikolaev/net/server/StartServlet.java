package ru.kpfu.itis.nikolaev.net.server;


import ru.kpfu.itis.nikolaev.net.dao.impl.MasterImpl;
import ru.kpfu.itis.nikolaev.net.dao.impl.RecordImpl;
import ru.kpfu.itis.nikolaev.net.dao.impl.ServiceImpl;
import ru.kpfu.itis.nikolaev.net.model.Master;
import ru.kpfu.itis.nikolaev.net.model.Record;
import ru.kpfu.itis.nikolaev.net.model.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "startServlet", urlPatterns = "/start")
public class StartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceImpl service = new ServiceImpl();
        MasterImpl master = new MasterImpl();
        //MasterServiceImpl masterService = new MasterServiceImpl();

        List<Service> listService = service.getAll();
        List<Master> listMaster = master.getAll();
        //List<MasterService> listMasterService = masterService.getAll();

        request.setAttribute("listService", listService);
        request.setAttribute("listMaster", listMaster);
        //request.setAttribute("listMasterService", listMasterService);
        request.getRequestDispatcher("reg.ftl").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idMaster = Integer.parseInt(request.getParameter("master"));
        int idService = Integer.parseInt(request.getParameter("service"));
        String dateString = request.getParameter("date");
        dateString = dateString.substring(0, dateString.indexOf(" ")+1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Timestamp timestamp = new Timestamp(date.getTime());
        String phone = request.getParameter("phone");
        Record record = new Record(idMaster, idService, (Timestamp) date, phone);
        RecordImpl recordImpl = new RecordImpl();
        recordImpl.save(record);
        response.sendRedirect("finish.ftl");
    }
}