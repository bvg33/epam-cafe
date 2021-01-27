package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.entity.Menu;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.logic.service.OrderPageService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

public class GoToOrderPageCommand implements Command{
    private static final String PAGE="WEB-INF/view/order.jsp";
    private final OrderPageService service;

    public GoToOrderPageCommand(OrderPageService orderPageService) {
        this.service=orderPageService;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException {
        List<Menu>menuList=service.getMenuFromBd();
        RequestContext context=helper.createContext();
        context.addSessionAttribute("menuList",menuList);
        helper.updateRequest(context);
        return CommandResult.forward(PAGE);
    }
}
