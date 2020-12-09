package com.epam.web.logic.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthenticationService {
    public boolean hasSession(HttpServletRequest request) {
        HttpSession session=request.getSession();
        String sessionId=session.getId();
        Cookie[] cookies=request.getCookies();
        if(cookies==null){
            return false;
        }
        for(Cookie cookie:cookies){
            if(cookie.getValue().equals(sessionId) && cookie.getName().equals("epam-cafe")){
                return true;
            }
        }
        return false;
    }
}