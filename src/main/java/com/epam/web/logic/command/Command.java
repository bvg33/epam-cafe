package com.epam.web.logic.command;

import com.epam.web.context.RequestContextHelper;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    /**
     *
     Performs the necessary actions using the parameters of RequestContext object
     * and returns CommandResult object with further page transition instructions
     *
     * @param helper - passed into the method requestContextHelper,to create RequestContext, which is contained all request parameters
     *                       and attributes and also session attributes
     * @param response HttpServletResponse
     * @return CommandResult - return commandResult forward or redirect
     * @return CommandResult Class to do forward or redirect
     * @throws IOException
     * @throws ServletException
     * @throws ServiceException
     */
    CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException, IOException, ServletException;
}
