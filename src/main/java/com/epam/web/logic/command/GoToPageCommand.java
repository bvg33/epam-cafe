package com.epam.web.logic.command;

import com.epam.web.context.RequestContextHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class GoToPageCommand implements Command {
    private String page;

    public GoToPageCommand(String page) {
        this.page = page;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) {
        return CommandResult.forward(page);
    }
}
