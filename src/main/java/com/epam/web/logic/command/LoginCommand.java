package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.entity.User;
import com.epam.web.logic.service.LoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;


public class LoginCommand implements Command {
    private static final String PASSWORD_PARAMETER = "password";
    private static final String LOGIN_PARAMETER = "login";
    private static final String GOTO_MAIN_PAGE_ADDRESS = "WEB-INF/view/order.jsp";
    private static final String LOGIN_PAGE_ADDRESS = "WEB-INF/view/login.jsp";
    private LoginService loginService;
    private NewUser users[]=new NewUser[13];

    public LoginCommand(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        for(int i=0;i<13;i++){
            users[i]=new NewUser("name"+i,"surname","30");
        }
        RequestContext requestContext=helper.createContext();
        String password = requestContext.getRequestParameter(PASSWORD_PARAMETER);
        String login = requestContext.getRequestParameter(LOGIN_PARAMETER);
        Optional<User> optionalResult = loginService.login(password, login);
        if (optionalResult.isPresent()) {
            requestContext.addSessionAttribute("user",optionalResult.get());
            createCookie(helper.getRequest(),response);
            requestContext.addRequestAttribute("users",users);
            helper.updateRequest(requestContext);
            return CommandResult.forward(GOTO_MAIN_PAGE_ADDRESS);
        }
        requestContext.addRequestAttribute("errorMessage",true);
        helper.updateRequest(requestContext);
        return CommandResult.forward(LOGIN_PAGE_ADDRESS);
    }

    private void createCookie(HttpServletRequest request,HttpServletResponse response) {
        String sessionId = request.getSession(true).getId();
        Cookie cookie = new Cookie("epam-cafe", sessionId);
        cookie.setDomain(request.getServerName());
        cookie.setPath(request.getContextPath());
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
    }
}