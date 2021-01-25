package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.dto.OrderDto;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.logic.service.GoToMyOrdersPageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class GoToMyOrdersPageCommand implements Command {
    private static final String PAGE="WEB-INF/view/myOrders.jsp";
    private final GoToMyOrdersPageService service;

    public GoToMyOrdersPageCommand(GoToMyOrdersPageService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws DaoException, IOException, ServletException, ServiceException {
        RequestContext context=helper.createContext();
        User user= (User) context.getSessionAttribute("user");
        int userId=user.getId();
        List<OrderDto> dtos=service.getAllUsersOrdersDto(userId);
        context.addRequestAttribute("orders",dtos);
        helper.updateRequest(context);
        return CommandResult.forward(PAGE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoToMyOrdersPageCommand that = (GoToMyOrdersPageCommand) o;
        return Objects.equals(service, that.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(service);
    }
}
