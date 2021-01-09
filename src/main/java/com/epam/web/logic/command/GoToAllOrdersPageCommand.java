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

public class GoToAllOrdersPageCommand implements Command {
    private final GoToAllOrdersPageService service;
    private static final String PAGE="WEB-INF/view/allOrders.jsp";
    public GoToAllOrdersPageCommand(GoToAllOrdersPageService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws DaoException, IOException, ServletException, ServiceException {
        List<OrderDto> orders=service.getAllOrders();
        RequestContext context=helper.createContext();
        context.addRequestAttribute("orders",orders);
        OrderStateEnum stateEnums[]=OrderStateEnum.values();
        context.addRequestAttribute("states",stateEnums);
        helper.updateRequest(context);
        return CommandResult.forward(PAGE);
    }
}
