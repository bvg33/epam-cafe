package com.epam.web.logic.command;

public class CommandResult {
    private boolean isRedirect;
    private String page;

    public CommandResult(boolean isRedirect, String page) {
        this.isRedirect = isRedirect;
        this.page = page;
    }

    public static CommandResult redirect(String page) {
        return new CommandResult(true, page);
    }

    public static CommandResult forward(String page) {
        return new CommandResult(false, page);
    }

    public boolean isRedirect() {
        return isRedirect;
    }

    public String getPage() {
        return page;
    }
}
