package com.epam.web.logic.service;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.entity.User;

import java.util.Objects;

public class LoginCheckService {
    public boolean hasSession(RequestContextHelper contextHelper) {
        RequestContext context = contextHelper.createContext();
        User user = (User) context.getSessionAttribute("user");
        if (user == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }

}