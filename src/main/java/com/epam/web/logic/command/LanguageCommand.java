package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class LanguageCommand implements Command {
    @Override
    public CommandResult execute(RequestContextHelper helper ,HttpServletResponse response) {
        RequestContext requestContext=helper.createContext();
        String language = requestContext.getRequestParameter("lang");
        requestContext.addSessionAttribute("local",language);
        String path=requestContext.getRequestParameter("path");
        helper.updateRequest(requestContext);
        return CommandResult.forward(path);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }

}