package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.entity.Role;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class GoToRolePageCommand implements Command {
    private static final String USER_PAGE = "WEB-INF/view/profile.jsp";
    private static final String ADMIN_PAGE = "command=goToAdminPage";


    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException {
        RequestContext context=helper.createContext();
        User user= (User) context.getSessionAttribute("user");
        if(user.getRole()== Role.USER){
            return CommandResult.forward(USER_PAGE);
        }else{
            return CommandResult.redirect(ADMIN_PAGE);
        }
    }
}
