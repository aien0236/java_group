package controller;

import dataaccesslayer.User.UserCookies;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogoutServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // check if user is logged in
        Map<String, String> cookieMap = UserCookies.getCookieMap(request);
        String username = cookieMap.get("username");
        // not logged in, redirect to login page
        if (username == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        // delete cookies if user is logged in then redirect back to login
        UserCookies.deleteSessionCookies(response);
        request.setAttribute("errorMessage", "You have been logged out");
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}
