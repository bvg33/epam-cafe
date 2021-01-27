package com.epam.web.logic.service;

import com.epam.web.dao.Dao;
import com.epam.web.dao.helper.DaoHelper;
import com.epam.web.dao.helper.DaoHelperFactory;
import com.epam.web.dao.menudao.MenuDaoImpl;
import com.epam.web.dao.userdao.UserDao;
import com.epam.web.entity.Menu;
import com.epam.web.enums.NewDishResponseEnum;
import com.epam.web.exceptions.ConnectionException;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.logic.validator.AbstractValidator;
import com.epam.web.logic.validator.LengthValidator;
import com.epam.web.logic.validator.PriceValidator;

import javax.servlet.ServletException;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.UUID;

public class AddNewDishService {
    private final DaoHelperFactory daoHelperFactory;
    public AddNewDishService(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public String createNewFileName(String fileName){
        return UUID.randomUUID().toString()+fileName;
    }

    public void saveFile(String fileName, Part part) throws  ServiceException {
        File file = new File(fileName);
        byte buffer[]=new byte[(int) part.getSize()];
        try(InputStream is=part.getInputStream();
            FileOutputStream fos=new FileOutputStream(file)) {
            is.read(buffer);
            file.createNewFile();
            fos.write(buffer);
            fos.flush();
        } catch (IOException e) {
            throw new ServiceException("Save file exception",e);
        }
    }
    public void addToMenu(Menu menu) throws ServiceException {
        try (DaoHelper daoHelper=daoHelperFactory.createDaoHelper()) {
            Dao dao=daoHelper.createMenuDao();
            dao.save(menu);
        }catch (DaoException | ConnectionException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public NewDishResponseEnum isValidData(String name, String price,AbstractValidator priceValidator,AbstractValidator lengthValidator){
        if(!priceValidator.isValid(price)){
            return NewDishResponseEnum.WRONG_PRICE;
        }else if(!lengthValidator.isValid(name)){
            return NewDishResponseEnum.WRONG_NAME;
        }
        return NewDishResponseEnum.OK;
    }
}
