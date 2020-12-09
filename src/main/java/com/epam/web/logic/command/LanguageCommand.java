package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LanguageCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        RequestContextHelper requestContextHelper=new RequestContextHelper();
        RequestContext requestContext=requestContextHelper.createContext(request);
        String language = requestContext.getRequestParameter("lang");
        requestContext.addSessionAttribute("local",language);
        String path=requestContext.getRequestParameter("path");
        requestContextHelper.updateRequest(request,requestContext);
        return CommandResult.forward(path);
    }
}