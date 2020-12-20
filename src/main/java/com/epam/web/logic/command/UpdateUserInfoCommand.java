package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.entity.Role;
import com.epam.web.entity.User;
import com.epam.web.logic.service.UpdateUserInfoService;

import javax.servlet.http.HttpServletResponse;

public class UpdateUserInfoCommand implements Command {
    private UpdateUserInfoService service;

    public UpdateUserInfoCommand(UpdateUserInfoService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws Exception {
        User currentUser= (User) helper.getRequest().getSession().getAttribute("user");
        RequestContext context=helper.createContext();
        String newLogin=context.getRequestParameter("login");
        String newName=context.getRequestParameter("name");;
        String newCardNumber=context.getRequestParameter("cardNumber");;
        int id=currentUser.getId();
        String password= currentUser.getPassword();
        int loyality=currentUser.getLoyality();
        Role role=currentUser.getRole();
        User newUser=new User(id,newLogin,password,newName,newCardNumber,loyality,role);
        service.updateInfo(newUser);
        return CommandResult.forward("dsfdsfds");
    }
}
