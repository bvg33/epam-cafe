package com.epam.web.dao.menudao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.dao.AbstractDao;
import com.epam.web.dao.extractor.FieldExtractorFactory;
import com.epam.web.dao.extractor.MenuFieldExtractor;
import com.epam.web.dao.mapper.RowMapperFactory;
import com.epam.web.entity.Menu;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class MenuDaoImpl extends AbstractDao<Menu>  {
    private static final String GET_ALL_QUERY="select * from "+Menu.TABLE+" where is_active=1";
    public MenuDaoImpl(ProxyConnection connection) {
        super(connection, RowMapperFactory.createMapper(Menu.TABLE), FieldExtractorFactory.createFieldExtractor(Menu.TABLE),Menu.TABLE);
    }

    @Override
    public List<Menu> getAll() throws DaoException {
       return executeQuery(GET_ALL_QUERY);
    }

    @Override
    public void removeById(Long id) throws DaoException {
        Optional<Menu> optionalEntity=getById(Math.toIntExact(id));
        Menu entity= optionalEntity.get();
        save(buildMenu(entity));
    }

    private Menu buildMenu(Menu menu){
        int id=menu.getId();
        String name=menu.getName();
        String price= menu.getPrice();
        String photo=menu.getPhoto();
        return new Menu(id,name,price,photo,0);
    }
}
