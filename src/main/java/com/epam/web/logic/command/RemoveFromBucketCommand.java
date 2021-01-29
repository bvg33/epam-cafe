package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.dto.MenuDto;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.logic.service.RemoveFromBucketService;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RemoveFromBucketCommand implements Command {
    private static final String PAGE="WEB-INF/view/bucket.jsp";
    private final RemoveFromBucketService service;
    private static final String ID="id";
    private static final String BUCKET="bucket";

    public RemoveFromBucketCommand(RemoveFromBucketService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response)  {
        RequestContext context = helper.createContext();
        String id = context.getRequestParameter(ID);
        int intId = Integer.parseInt(id);
        ArrayList<MenuDto> bucket = (ArrayList<MenuDto>) context.getSessionAttribute(BUCKET);
        service.remove(bucket,intId);
        return CommandResult.forward(PAGE);
    }
}
