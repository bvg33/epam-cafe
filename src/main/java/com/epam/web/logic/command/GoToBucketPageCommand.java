package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.logic.service.GoToBucketPageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Objects;

public class GoToBucketPageCommand implements Command {
    private static final String PAGE = "WEB-INF/view/bucket.jsp";
    private final GoToBucketPageService service;

    public GoToBucketPageCommand(GoToBucketPageService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException, IOException, ServletException {
        Map<String, String> time = service.getTime(new GregorianCalendar());
        RequestContext context = helper.createContext();
        context.addRequestAttribute("minDate",time.get("minDate"));
        context.addRequestAttribute("maxDate",time.get("maxDate"));
        helper.updateRequest(context);
        return CommandResult.forward(PAGE);
    }
}
