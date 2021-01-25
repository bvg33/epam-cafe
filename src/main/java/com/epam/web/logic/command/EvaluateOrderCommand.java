package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.entity.Rating;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.logic.service.EvaluateOrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class EvaluateOrderCommand implements Command {
    private final EvaluateOrderService service;
    private static final String COMMAND="command=goToMyOrdersPage";
    public EvaluateOrderCommand(EvaluateOrderService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws DaoException, IOException, ServletException, ServiceException {
        RequestContext context=helper.createContext();
        Rating rating=createRating(context);
        service.evaluateOrder(rating);
        return CommandResult.redirect(COMMAND);
    }

    private Rating createRating(RequestContext context){
        String ratingString=context.getRequestParameter("rating");
        int rating=Integer.parseInt(ratingString);
        String orderIdString=context.getRequestParameter("orderId");
        int  orderId=Integer.valueOf(orderIdString);
        return new Rating(0,orderId,rating);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EvaluateOrderCommand that = (EvaluateOrderCommand) o;
        return Objects.equals(service, that.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(service);
    }
}
