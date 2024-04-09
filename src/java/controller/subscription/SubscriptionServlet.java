package controller.subscription;

import dataaccesslayer.User.UserCookies;
import dataaccesslayer.subscription.AlertLogDao;
import dataaccesslayer.subscription.SubscriptionDao;
import dataaccesslayer.subscription.impl.AlertLogDaoImpl;
import dataaccesslayer.subscription.impl.SubscriptionDaoImpl;
import model.subscription.AlertLog;
import model.subscription.Subscription;
import schedule.SubSchedule;
import utlis.ReflectionUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionServlet extends HttpServlet {

    public static boolean developerMode = false;

    private SubscriptionDao subscriptionDao = new SubscriptionDaoImpl();

    private AlertLogDao alertLogDao = new AlertLogDaoImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
//            List<AlertLog> logs = alertLogDao.findAll();
//            request.setAttribute("logs", logs);
//            request.getRequestDispatcher("views/consumer/home.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String url = request.getRequestURI();
            addSub(request, response);

            if (url.endsWith("addSub")) {
            } else {
                // default handler
                defaultMethod(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addSub(HttpServletRequest request, HttpServletResponse response) {
        Subscription subscription = new Subscription();
        ReflectionUtils.reflectParameter(subscription, request);
        String userId = UserCookies.getUserId(request);
        subscription.setUserId(userId != null && userId.length() != 0 ? Long.valueOf(userId) : null);
        subscriptionDao.add(subscription);
    }

    private void defaultMethod(HttpServletRequest request, HttpServletResponse response) {

    }
}
