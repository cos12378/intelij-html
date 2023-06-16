package com.playdata.todos.servlet;

import com.playdata.todos.config.History;
import dao.UserDao;
import dto.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        History.setHistory(req, resp);

        req.getRequestDispatcher("views/login.html").forward(req, resp);

        BackServlet.back(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new UserDao().login(username,password);
//        Cookie cookie2 = new Cookie("uid", user.getName());
//        Cookie cookie = new Cookie("uname", user.getId().toString());
//        resp.addCookie(cookie);
//        resp.addCookie(cookie2);
//        cookie.setMaxAge(10);
        HttpSession session = req.getSession();
        session.setAttribute("uname", user.getName());
        if(user!=null){
            resp.sendRedirect("/main");
        }else resp.sendRedirect("/user");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
