package com.epam.web.logic.service;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.entity.User;

public class LoginCheckService {
    public boolean hasSession(RequestContextHelper contextHelper) {
        RequestContext context = contextHelper.createContext();
        User user = (User) context.getSessionAttribute("user");
        if (user == null) {
            return false;
        }
        return true;
    }
}