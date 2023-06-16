package com.playdata.todos.servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.playdata.todos.config.History;

public class BackServlet {
    public static void back(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie[] cookies = req.getCookies();
        String historyCookieName = "history";
        int index = 0;
        int max = 0;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().contains(historyCookieName)) {
                    int cookieIndex = Integer.parseInt(c.getName().replace(historyCookieName, ""));
                    if (cookieIndex > index) {
                        index = cookieIndex;
                        try {
                            max = Integer.parseInt(c.getValue());
                        } catch (NumberFormatException e) {
                            // Handle non-integer cookie value
                            max = 0;
                        }
                    }
                }
            }
        }

        if (index > 0) {
            Cookie cookieToRemove = new Cookie(historyCookieName + index, String.valueOf(max));
            cookieToRemove.setMaxAge(0); // Remove the cookie
            resp.addCookie(cookieToRemove);

            index--;
            if (index > 0) {
                Cookie cookieToRedirect = new Cookie(historyCookieName + index, "");
                resp.addCookie(cookieToRedirect);
                resp.sendRedirect(cookies[index].getValue()); // Redirect to the previous page
            }
        }
    }
}
