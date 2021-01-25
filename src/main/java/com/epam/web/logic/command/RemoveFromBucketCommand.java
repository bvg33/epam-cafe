package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.dto.MenuDto;
import com.epam.web.exceptions.DaoException;
import com.epam.web.logic.service.RemoveFromBucketService;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RemoveFromBucketCommand implements Command {
    private static final String PAGE="WEB-INF/view/bucket.jsp";
    private final RemoveFromBucketService service;

    public RemoveFromBucketCommand(RemoveFromBucketService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws DaoException {
        RequestContext context = helper.createContext();
        String id = context.getRequestParameter("id");
        int intId = Integer.parseInt(id);
        ArrayList<MenuDto> bucket = (ArrayList<MenuDto>) context.getSessionAttribute("bucket");
        service.remove(bucket,intId);
        return CommandResult.forward(PAGE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RemoveFromBucketCommand that = (RemoveFromBucketCommand) o;
        return Objects.equals(service, that.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(service);
    }
}
