package com.epam.web.logic.command;

import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.logic.service.AuthenticationService;
import com.epam.web.logic.service.LoginService;

public class CommandFactory {
    public static Command createCommand(String command) {
        switch (command) {
            case "login":
                return new LoginCommand(new LoginService(new DaoHelperFactory()));
            case "language":
                return new LanguageCommand();
            case "logout":
                return new LogoutCommand();
            case "goToOrderPage":
                return new GoToPageCommand("WEB-INF/view/order.jsp");
            case "goToLogin":
                return new GoToPageCommand("WEB-INF/view/login.jsp");
            case "goToProfilePage":
                return new GoToPageCommand("WEB-INF/view/profile.jsp");
            case "goToEvaluatePage":
                return new GoToPageCommand("WEB-INF/view/evaluate.jsp");
            case "authentication":
                return new AuthenticationCommand(new AuthenticationService());
            default:
                throw new IllegalArgumentException("Illegal string");
        }
    }
}
