package dataaccesslayer.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class UserCookies {
    /**
     * Sets the cookie expiration to one month
     **/
    public static final int COOKIE_TIME = 60 * 60 * 24 * 30;

    /**
     * Create cookies for username and email that expire in one month
     *
     * @param username the username to save as a cookie
     * @param email    the email to save as a cookie
     * @param response the response to add cookies to
     */
    public static void createSessionCookies(String username, String email, int id, HttpServletResponse response) {
        // create username cookie
        Cookie usernameCookie = new Cookie("username", username);
        usernameCookie.setMaxAge(COOKIE_TIME);
        response.addCookie(usernameCookie);
        // create email cookie
        Cookie emailCookie = new Cookie("email", email);
        emailCookie.setMaxAge(COOKIE_TIME);
        response.addCookie(emailCookie);
        // create id cookie
        Cookie idCookie = new Cookie("id", "" + id);
        idCookie.setMaxAge(COOKIE_TIME);
        response.addCookie(idCookie);

    }

    /**
     * Deletes all cookies
     *
     * @param response the response to delete cookies with
     */
    public static void deleteSessionCookies(HttpServletResponse response) {
        // add username cookie
        Cookie usernameCookie = new Cookie("username", "");
        usernameCookie.setMaxAge(0);
        response.addCookie(usernameCookie);
        // add email cookie
        Cookie emailCookie = new Cookie("email", "");
        emailCookie.setMaxAge(0);
        response.addCookie(emailCookie);
        // add id cookie
        Cookie idCookie = new Cookie("id", "");
        idCookie.setMaxAge(0);
        response.addCookie(idCookie);
    }

    /**
     * Returns a hashMap (key-value pairs) of cookies so you can reference
     * the cookies by key value ('username', 'email')
     *
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
