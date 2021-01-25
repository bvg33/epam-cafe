package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class LogoutCommand implements Command {
    private static final String USER_ATTRIBUTE = "user";
    private static final String BUCKET_ATTRIBUTE = "bucket";
    private static final String MENU_ATTRIBUTE = "menuList";
    private static final String LOGIN_PAGE_ADDRESS = "WEB-INF/view/login.jsp";
    public int test;
    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        RequestContext context=helper.createContext();
        context.removeSessionAttribute(USER_ATTRIBUTE);
        context.removeSessionAttribute(BUCKET_ATTRIBUTE);
        context.removeSessionAttribute(MENU_ATTRIBUTE);
        helper.updateRequest(context);
        return CommandResult.forward(LOGIN_PAGE_ADDRESS);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }

}
