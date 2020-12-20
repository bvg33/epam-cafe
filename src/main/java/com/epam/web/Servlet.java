package com.epam.web;

import com.epam.web.connection.ConnectionPool;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.exceptions.ConnectionException;
import com.epam.web.logic.command.Command;
import com.epam.web.logic.command.CommandFactory;
import com.epam.web.logic.command.CommandResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {
    //TODO при кэтче ошибки слать ее юзеру
    private static final String COMMAND = "command";
    private static final String PATH = "/epam_cafe_war_exploded/controller?";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        process(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        process(req, resp);
    }
    @Override
    public void destroy() {
        try {
            ConnectionPool.getInstance().destroy();
            super.destroy();
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String commandParameter = req.getParameter(COMMAND);
            Command command = CommandFactory.createCommand(commandParameter);
            RequestContextHelper contextHelper=new RequestContextHelper(req);
            CommandResult result = command.execute(contextHelper, resp);
            dispatch(result, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dispatch(CommandResult result, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        if (result.isRedirect()) {
            resp.sendRedirect(PATH + result.getPage());
        } else {
            req.getRequestDispatcher(result.getPage()).forward(req, resp);
        }
    }
}
