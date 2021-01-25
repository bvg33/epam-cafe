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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoToPageCommand that = (GoToPageCommand) o;
        return Objects.equals(page, that.page);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page);
    }
}
