package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.entity.Menu;
import com.epam.web.enums.NewDishResponseEnum;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.logic.service.AddNewDishService;
import com.epam.web.logic.validator.AbstractValidator;
import com.epam.web.logic.validator.LengthValidator;
import com.epam.web.logic.validator.LoginValidator;
import com.epam.web.logic.validator.PriceValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Objects;

public class AddNewDishCommand implements Command {
    private final AddNewDishService service;
    private static final String PAGE = "command=goToNewDishPage";
    private static final String CURRENT_PAGE="WEB-INF/view/newDish.jsp";
    private static final String NAME="name";
    private static final String PRICE="price";
    private static final String BYN="BYN";
    private static final String FILE="file";
    private static final String PHOTO_PATH="static\\images\\";
    private static final String ERROR="error";

    public AddNewDishCommand(AddNewDishService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws IOException, ServletException, ServiceException {
        RequestContext context = helper.createContext();
        String name = context.getRequestParameter(NAME);
        String price = context.getRequestParameter(PRICE)+BYN;
        NewDishResponseEnum result=service.isValidData(name,price,new PriceValidator(),new LengthValidator());
        if (result==NewDishResponseEnum.OK) {
            Part part = helper.getRequest().getPart(FILE);
            String fileName = part.getSubmittedFileName();
            fileName = service.createNewFileName(fileName);
            String path = helper.getRequest().getServletContext().getRealPath("") + PHOTO_PATH + fileName;
            service.saveFile(path, part);
            Menu dish = new Menu(0, name, price, fileName,1);
            service.addToMenu(dish);
            return CommandResult.redirect(PAGE);
        }else if (result==NewDishResponseEnum.WRONG_PRICE){
            context.addRequestAttribute(ERROR,NewDishResponseEnum.WRONG_PRICE);
        }else{
            context.addRequestAttribute(ERROR,NewDishResponseEnum.WRONG_NAME);
        }
        helper.updateRequest(context);
        return CommandResult.forward(CURRENT_PAGE);
    }

}
