package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.entity.Menu;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.logic.service.OrderPageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class GoToRemoveFromMenuPageCommand implements Command {
    private static final String PAGE="WEB-INF/view/removeDish.jsp";
    private final OrderPageService service;
    private static final String MENU_LIST="menuList";
    public GoToRemoveFromMenuPageCommand(OrderPageService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException {
        List<Menu> menuList=service.getMenuFromBd();
        RequestContext context=helper.createContext();
        context.addSessionAttribute(MENU_LIST,menuList);
        helper.updateRequest(context);
        return CommandResult.forward(PAGE);
    }
}
