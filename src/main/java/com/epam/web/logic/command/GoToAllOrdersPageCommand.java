package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.dto.OrderDto;
import com.epam.web.enums.OrderStateEnum;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.logic.service.GoToAllOrdersPageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GoToAllOrdersPageCommand implements Command {
    private final GoToAllOrdersPageService service;
    private static final String PAGE="WEB-INF/view/allOrders.jsp";
    private static final String ORDERS="orders";
    private static final String STATES="states";

    public GoToAllOrdersPageCommand(GoToAllOrdersPageService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws  ServiceException {
        List<OrderDto> orders=service.getAllOrders();
        RequestContext context=helper.createContext();
        context.addRequestAttribute(ORDERS,orders);
        OrderStateEnum stateEnums[]=OrderStateEnum.values();
        context.addRequestAttribute(STATES,stateEnums);
        helper.updateRequest(context);
        return CommandResult.forward(PAGE);
    }
}
