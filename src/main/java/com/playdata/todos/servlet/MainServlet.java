package com.playdata.todos.servlet;

import com.playdata.todos.config.History;
import dao.UserDao;
import dto.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("views/main.html").forward(req, resp);
        resp.setContentType("text/html;charset=UTF-8");
        History.setHistory(req, resp);

        Cookie[] cookies = req.getCookies();
        String uid = null;
        String uname = null;
        BackServlet.back(req,resp);
        for (Cookie c : cookies) {
            if (c.getName().equals("uid")) uid = c.getValue();
            if (c.getName().equals("uname")) uname = c.getValue();
        }
        HttpSession session = req.getSession();
        if(session.getAttribute("uname")!=null){
            session.getAttribute("uname");
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = resp.getWriter();
            writer.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>main</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <h1>"+ session.getAttribute("uname")+  " 환영합니다.</h1>\n" +
                    "    <img src=\"/img/춘식이2.jpg\">\n" +
                    " <a href=\"/back\">back></a>\n"+
                    "</body>\n" +
                    "</html>");

            writer.close();

        }

    }
}
