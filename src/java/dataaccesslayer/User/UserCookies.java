package dataaccesslayer.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class UserCookies {
    /** Sets the cookie expiration to one month **/
    public static final int COOKIE_TIME = 60 * 60 * 24 * 30;

    /**
     * Create cookies for username and email that expire in one month
     * @param username the username to save as a cookie
     * @param email the email to save as a cookie
     * @param response the response to add cookies to
     */
    public static void createSessionCookies(String username, String email, HttpServletResponse response) {
        Cookie usernameCookie = new Cookie("username", username);
        usernameCookie.setMaxAge(COOKIE_TIME);
        response.addCookie(usernameCookie);
        Cookie emailCookie = new Cookie("email", email);
        emailCookie.setMaxAge(COOKIE_TIME);
        response.addCookie(emailCookie);
    }

    /**
     * Deletes all cookies
     * @param response the response to delete cookies with
     */
    public static void deleteSessionCookies(HttpServletResponse response) {
        Cookie usernameCookie = new Cookie("username", "");
        usernameCookie.setMaxAge(0);
        response.addCookie(usernameCookie);
        Cookie emailCookie = new Cookie("email", "");
        emailCookie.setMaxAge(0);
        response.addCookie(emailCookie);
    }

    /**
     * Returns a hashMap (key-value pairs) of cookies so you can reference
     * the cookies by key value ('username', 'email')
     * @param request the request to get cookies from
     * @return hashMap of cookies
     */
    public static Map<String, String> getCookieMap(HttpServletRequest request) {
        Map<String, String> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie.getValue());
            }
        }
        return cookieMap;
    }
}
