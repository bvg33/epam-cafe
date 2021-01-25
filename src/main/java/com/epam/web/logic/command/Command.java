package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    /**
     *
     * method to execute query
     * @param helper Class to create RequestContext
     * @param response HttpServletResponse
     * @return CommandResult Class to do forward or redirect
     * @throws DaoException
     * @throws IOException
     * @throws ServletException
     * @throws ServiceException
     */
    CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws DaoException, IOException, ServletException, ServiceException;
}
