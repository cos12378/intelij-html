//package com.playdata.todos.servlet;
//
//import dao.TodoDao;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class TodoUpdateServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getParameter("todoid"));
//        req.setAttribute("todoid",req.getParameter("todoid"));
//        int id= Integer.parseInt(req.getParameter("todoid"));
//        String content = new TodoDao().findById(id).getContent();
//        req.setAttribute("content", "fdsafdsa");
//        req.getRequestDispatcher("/view/toupdate.jsp").forward(req,resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }
//}
