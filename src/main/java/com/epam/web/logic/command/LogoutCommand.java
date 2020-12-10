package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommand implements Command {
    private static final String SESSION_ATTRIBUTE = "user";
    private static final String LOGIN_PAGE_ADDRESS = "WEB-INF/view/login.jsp";

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext context=helper.createContext();
        context.removeSessionAttribute(SESSION_ATTRIBUTE);
        helper.updateRequest(context);
        removeCookies(response);
        return CommandResult.forward(LOGIN_PAGE_ADDRESS);
    }
    private void removeCookies(HttpServletResponse response){
        Cookie cookie=new Cookie("epam-cafe",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
