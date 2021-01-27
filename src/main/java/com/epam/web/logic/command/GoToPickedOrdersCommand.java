package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.dto.OrderDto;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.logic.service.GoToPickedOrdersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GoToPickedOrdersCommand implements Command {
    private final GoToPickedOrdersService service;
    private static final String PAGE="WEB-INF/view/pickedOrders.jsp";
    public GoToPickedOrdersCommand(GoToPickedOrdersService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException {
        List<OrderDto> orders=service.getPickedOrders();
        RequestContext context=helper.createContext();
        context.addRequestAttribute("orders",orders);
        helper.updateRequest(context);
        return CommandResult.forward(PAGE);
    }
}
