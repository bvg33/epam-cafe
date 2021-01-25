package com.epam.web.logic.command;

import com.epam.web.context.RequestContextHelper;
import com.epam.web.logic.service.LoginCheckService;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class LoginCheckCommand implements Command {
    private final LoginCheckService service;
    private static final String MAIN_PAGE_PATH="WEB-INF/view/order.jsp";
    private static final String LOGIN_PAGE_PATH="WEB-INF/view/login.jsp";
    public LoginCheckCommand(LoginCheckService service) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginCheckCommand that = (LoginCheckCommand) o;
        return Objects.equals(service, that.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(service);
    }
}