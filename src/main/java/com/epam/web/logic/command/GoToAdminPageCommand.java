package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.logic.service.GoToAdminPageService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

public class GoToAdminPageCommand implements Command {
    private final GoToAdminPageService service;
    private static final String ADMIN_PAGE = "WEB-INF/view/admin.jsp";
    private static final String USERS="users";
    public GoToAdminPageCommand(GoToAdminPageService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException {
        RequestContext context = helper.createContext();
        List<User> users = service.findUsers();
        context.addRequestAttribute(USERS, users);
        helper.updateRequest(context);
        return CommandResult.forward(ADMIN_PAGE);
    }
}
