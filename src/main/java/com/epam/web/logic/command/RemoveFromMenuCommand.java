package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.logic.service.RemoveFromBucketService;
import com.epam.web.logic.service.RemoveFromMenuService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class RemoveFromMenuCommand implements Command{
    private final RemoveFromMenuService service;
    private static final String PAGE="command=goToRemoveFromMenuPage";
    private static final String DISH_ID="dishID";

    public RemoveFromMenuCommand(RemoveFromMenuService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException {
        RequestContext context=helper.createContext();
        String dishId=context.getRequestParameter(DISH_ID);
        int id=Integer.parseInt(dishId);
        service.removeDish(id);
        return CommandResult.redirect(PAGE);
    }
}
