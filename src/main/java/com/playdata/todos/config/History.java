package com.playdata.todos.config;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class History {
    public static void setHistory(HttpServletRequest req, HttpServletResponse resp) {
//            Cookie[] cookies = req.getCookies();
//            String requestURI = req.getRequestURI();
//            String history = "history";
//            int index = 0;
//            int max = 0;
//            if(cookies == null) {
//                resp.addCookie(new Cookie(history + index , requestURI);
//                return;
//            }
//            for (int i=0; i < cookies.length; i++) {
//                Cookie c = cookies [i];
//                if(c.getName().contains(history))
//                    if(index<Integer.parseInt(c.getName().replace(history,"")))
//                    index = Integer.parseInt(
//                            c.getName().replace(history,"")
//                    );
//                    max = i;
//            }
//            index++;
//            if(!cookies[max].getValue().equals(requestURI))
//                resp.addCookie(new Cookie(history + index , requestURI));
        Cookie[] cookies = req.getCookies();
        String history = "history";
        int index = 0;
        int max = 0;

        if (cookies != null && cookies.length>0) {
            for (Cookie c : cookies) {
                if (c.getName().contains(history)) {
                    int cookieIndex = Integer.parseInt(c.getName().replace(history, ""));
                    if (cookieIndex > index) {
                        index = cookieIndex;
                        try {
                            max = Integer.parseInt(c.getValue());
                        } catch (NumberFormatException e) {
                            // Handle non-integer cookie value
                            // You can choose to ignore or set a default value
                            max = 0;
                        }
                    }
                }

            }
        } else {

        }
}

}
//        for (Cookie c : cookies) {
//            if (c.getName().equals("history")) history = c.getValue();
//        }
//        System.out.println("history: " + history);
//        String requestURI = req.getRequestURI();
//        String servletPath = req.getServletPath();
//        String contextPath = req.getContextPath();
//        if (history.length() == 0) {
//            history = "";
//        } else {
//            history += "," + requestURI;
//            resp.addCookie(new Cookie("", history));
//        }


