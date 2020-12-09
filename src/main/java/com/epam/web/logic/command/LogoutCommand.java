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
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        RequestContextHelper contextHelper=new RequestContextHelper();
        RequestContext context=contextHelper.createContext(request);
        context.removeSessionAttribute(SESSION_ATTRIBUTE);
        contextHelper.updateRequest(request,context);
        removeCookies(request,response);
        return CommandResult.forward(LOGIN_PAGE_ADDRESS);
    }
    private void removeCookies(HttpServletRequest request,HttpServletResponse response){
        Cookie cookie=new Cookie("epam-cafe",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
