package com.epam.web.logic.command;

import com.epam.web.context.RequestContextHelper;
import com.epam.web.logic.service.AuthenticationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationCommand implements Command {
    private final AuthenticationService service;
    private static final String MAIN_PAGE_PATH="WEB-INF/view/order.jsp";
    private static final String LOGIN_PAGE_PATH="WEB-INF/view/login.jsp";
    public AuthenticationCommand(AuthenticationService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        boolean result=service.hasSession(helper);
        if(result){
            return CommandResult.forward(MAIN_PAGE_PATH);
        }
        return CommandResult.forward(LOGIN_PAGE_PATH);
    }
}