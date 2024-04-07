package controller;

import javax.servlet.ServletContext;

public class ServletContextHelper {
    private static ServletContext servletContext;

    public static void setServletContext(ServletContext context) {
        servletContext = context;
    }

    public static ServletContext getServletContext() {
        return servletContext;
    }
}
