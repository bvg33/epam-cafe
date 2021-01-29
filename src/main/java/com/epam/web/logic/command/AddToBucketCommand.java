package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.dao.converter.MenuConverter;
import com.epam.web.dao.menudao.MenuDaoImpl;
import com.epam.web.dto.MenuDto;
import com.epam.web.entity.Menu;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.logic.service.AddToBucketService;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class AddToBucketCommand implements Command {
    private static final String PAGE="WEB-INF/view/order.jsp";
    private static final String DISH_ID="dishID";
    private static final String BUCKET="bucket";

    private final AddToBucketService service;

    public AddToBucketCommand(AddToBucketService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws ServiceException {
        RequestContext context=helper.createContext();
        String id=context.getRequestParameter(DISH_ID);
        int intId=Integer.parseInt(id);
        MenuDto menuDto=service.createMenuDto(intId,new MenuConverter());
        ArrayList<MenuDto> bucket= (ArrayList<MenuDto>) context.getSessionAttribute(BUCKET);
        if(bucket==null){
            ArrayList<MenuDto> newBucket=  service.createBucket(menuDto);
            context.addSessionAttribute(BUCKET,newBucket);
            helper.updateRequest(context);
            return CommandResult.forward(PAGE);
        }
        if(bucket.contains(menuDto)){
           service.updateBucket(menuDto,bucket);
        }else {
            bucket.add(menuDto);
        }
        helper.updateRequest(context);
        return CommandResult.forward(PAGE);
    }
}
