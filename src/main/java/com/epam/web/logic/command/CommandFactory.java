package com.epam.web.logic.command;

import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.logic.service.AuthenticationService;
import com.epam.web.logic.service.LoginService;
import com.epam.web.logic.service.OrderPageService;
import com.epam.web.logic.service.UpdateUserInfoService;

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
                return new GoToOrderPageCommand(new OrderPageService(new DaoHelperFactory()));
            case "goToLogin":
                return new GoToPageCommand("WEB-INF/view/login.jsp");
            case "goToProfilePage":
                return new GoToPageCommand("WEB-INF/view/profile.jsp");
            case "goToEvaluatePage":
                return new GoToPageCommand("WEB-INF/view/evaluate.jsp");
            case "authentication":
                return new AuthenticationCommand(new AuthenticationService());
            case "updateUserInfo":
                return new UpdateUserInfoCommand(new UpdateUserInfoService(new DaoHelperFactory()));
            default:
                throw new IllegalArgumentException("Illegal string");
        }
    }
}
