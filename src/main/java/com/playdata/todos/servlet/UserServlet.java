package com.playdata.todos.servlet;

import com.playdata.todos.config.History;
import dao.UserDao;
import dto.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        History.setHistory(req, resp);

        req.getRequestDispatcher("views/user.html").forward(req,resp);
        resp.setStatus(200);
        BackServlet.back(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        User user = new User ( null, username, password, name, null);
        UserDao userDao = new UserDao();
        UserDao.insert(user);
        resp.sendRedirect("/login");
    }



    @Override
    public void destroy() {
        super.destroy();
    }



}
