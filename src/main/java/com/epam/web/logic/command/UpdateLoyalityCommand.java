package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.entity.Role;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.logic.service.UpdateLoyalityService;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class UpdateLoyalityCommand implements Command {
    private final UpdateLoyalityService service;
    public static final String PAGE="command=goToAdminPage";
    private static final String ID="id";
    private static final String LOYALITY="loyality";


    public UpdateLoyalityCommand(UpdateLoyalityService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException {
        RequestContext context=helper.createContext();
        String id=context.getRequestParameter(ID);
        int intId=Integer.parseInt(id);
        String loyality=context.getRequestParameter(LOYALITY);
        int loyalityDelta=Integer.parseInt(loyality);
        User user=service.getUser(intId);
        User newUserInfo=createNewUserInfo(user,loyalityDelta);
        service.updateLoyality(newUserInfo);
        return CommandResult.redirect(PAGE);
    }

    private User createNewUserInfo(User user, int loyalityDelta) {
        int id=user.getId();
        Role role=user.getRole();
        String cardNumber=user.getCardNumber();
        String login=user.getLogin();
        int loyality=user.getLoyality()+loyalityDelta;
        String name=user.getName();
        String password=user.getPassword();
        return new User(id,login,password,name,cardNumber,loyality,role);
    }
}
