package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class LanguageCommand implements Command {
    private static final String LANG="lang";
    private static final String LOCAL="local";
    private static final String PATH="path";

    @Override
    public CommandResult execute(RequestContextHelper helper ,HttpServletResponse response) {
        RequestContext requestContext=helper.createContext();
        String language = requestContext.getRequestParameter(LANG);
        requestContext.addSessionAttribute(LOCAL,language);
        String path=requestContext.getRequestParameter(PATH);
        helper.updateRequest(requestContext);
        return CommandResult.forward(path);
    }
}