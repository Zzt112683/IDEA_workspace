package com.neuedu.util;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;

public class CookieUtil {

    /**
     * 将cookie数组变成集合方便操作
     * @param cookies
     * @return
     */
    public static Map<String,Cookie> getCookieMap(Cookie[] cookies){
        Map<String,Cookie> cookieMap = new HashMap<>();
        if (cookies != null){
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(),cookie);
            }
        }

        return cookieMap;
    }
}
