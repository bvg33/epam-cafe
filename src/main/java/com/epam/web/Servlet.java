package com.epam.web;

import com.epam.web.connection.ConnectionPool;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.exceptions.ConnectionException;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.logic.command.Command;
import com.epam.web.logic.command.CommandFactory;
import com.epam.web.logic.command.CommandResult;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {
    private static final String COMMAND = "command";
    private static final String PATH = "/epam_cafe_war_exploded/controller?"; //for idea
    //private static final String PATH = "/web/controller?"; //for tomcat
    private static final Logger LOGGER=Logger.getLogger(Servlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (ServiceException e) {
            LOGGER.error(e.getMessage());
            throw new ServletException(e.getMessage(),e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (ServiceException e) {
            LOGGER.error(e.getMessage());
            throw new ServletException(e.getMessage(),e);
        }

    }

    @Override
    public void destroy() {
        try {
            ConnectionPool.getInstance().destroy();
            super.destroy();
        } catch (ConnectionException e) {
            LOGGER.error(e.getMessage(),e);
        }
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ServiceException {
        String commandParameter = req.getParameter(COMMAND);
        Command command = CommandFactory.createCommand(commandParameter);
        RequestContextHelper contextHelper = new RequestContextHelper(req);
        CommandResult result = command.execute(contextHelper, resp);
        dispatch(result, req, resp);
    }

    private void dispatch(CommandResult result, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (result.isRedirect()) {
            resp.sendRedirect(PATH + result.getPage());
        } else {
            req.getRequestDispatcher(result.getPage()).forward(req, resp);
        }
    }
}