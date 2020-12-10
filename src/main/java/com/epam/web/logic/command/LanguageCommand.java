package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
}