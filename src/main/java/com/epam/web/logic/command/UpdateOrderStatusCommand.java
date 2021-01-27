package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.entity.Order;
import com.epam.web.enums.OrderStateEnum;
import com.epam.web.enums.OrderTypeEnum;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.logic.service.UpdateOrderStatusService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class UpdateOrderStatusCommand implements Command {
    private final UpdateOrderStatusService service;
    private static final String COMMAND="command=goToAllOrdersPage";
    public UpdateOrderStatusCommand(UpdateOrderStatusService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws  ServiceException {
        RequestContext context=helper.createContext();
        String state=context.getRequestParameter("state").toUpperCase();
        String idString=context.getRequestParameter("id");
        int id=Integer.parseInt(idString);
        Order order=service.getCurrentOrder(id);
        Order newOrderInfo=buildNewOrderInfo(state,order);
        service.updateOrder(newOrderInfo);
        return CommandResult.redirect(COMMAND);
    }

    private Order buildNewOrderInfo(String state,Order order) {
        int id=order.getId();
        String price=order.getPrice();
        OrderStateEnum stateEnum=OrderStateEnum.valueOf(state);
        OrderTypeEnum type=order.getType();
        String time=order.getTime();
        int userId=order.getUserId();
        return new Order(id,price,type,stateEnum,time,userId);
    }
}
