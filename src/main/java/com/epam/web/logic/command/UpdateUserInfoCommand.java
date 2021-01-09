package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.entity.Role;
import com.epam.web.entity.User;
import com.epam.web.enums.UserInfoResponseEnum;
import com.epam.web.exceptions.DaoException;
import com.epam.web.logic.service.UpdateUserInfoService;

import javax.servlet.http.HttpServletResponse;

public class UpdateUserInfoCommand implements Command {
    private UpdateUserInfoService service;

    private static final String LOGOUT = "command=logout";
    private static final String CURRENT_PAGE = "WEB-INF/view/profile.jsp";

    public UpdateUserInfoCommand(UpdateUserInfoService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws DaoException {
        User currentUser = (User) helper.getRequest().getSession().getAttribute("user");
        RequestContext context = helper.createContext();
        String newLogin = context.getRequestParameter("login");
        String newName = context.getRequestParameter("name");
        String newCardNumber = context.getRequestParameter("cardNumber");
        int id = currentUser.getId();
        UserInfoResponseEnum isUpdatable = service.isUpdatableInfo(newLogin, newName, newCardNumber, id);
        if (isUpdatable == UserInfoResponseEnum.OK) {
            User newUserInfo = createUser(id,newLogin,newName,newCardNumber,currentUser);
            service.updateInfo(newUserInfo);
            return CommandResult.redirect(LOGOUT);
        }
        context.addRequestAttribute("error", isUpdatable.toString());
        helper.updateRequest(context);
        return CommandResult.forward(CURRENT_PAGE);
    }

    private User createUser(int id, String newLogin, String newName, String newCardNumber, User currentUser) {
        String password = currentUser.getPassword();
        int loylity = currentUser.getLoyality();
        Role role = currentUser.getRole();
        return new User(id, newLogin, password, newName, newCardNumber, loylity, role);
    }
}
