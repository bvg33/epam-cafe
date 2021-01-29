package com.epam.web.logic.service;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.entity.User;

import java.util.Objects;

public class LoginCheckService {
    private static final String USER="user";
    public boolean hasSession(RequestContextHelper contextHelper) {
        RequestContext context = contextHelper.createContext();
        User user = (User) context.getSessionAttribute(USER);
        if (user == null) {
            return false;
        }
        return true;
    }
}