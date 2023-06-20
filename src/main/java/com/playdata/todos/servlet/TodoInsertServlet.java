//package com.playdata.todos.servlet;
//
//import dao.TodoDao;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//public class TodoInsertServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        String uname = (String) session.getAttribute("unmae");
//        req.setAttribute("uname",uname);
//        req.getRequestDispatcher("/view/todos.jsp").forward(req,resp);
//
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String content = req.getParameter("content");
//        int uid = (Integer) req.getSession().getAttribute("uid");
//        new TodoDao().insert(uid,content);
//        resp.sendRedirect("main");
//
//
//    }
//}
