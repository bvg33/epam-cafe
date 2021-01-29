package com.epam.web.dao.mapper;

import com.epam.web.entity.Menu;
import com.epam.web.exceptions.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class MenuRowMapper implements RowMapper<Menu> {
    private static final String IS_ACTIVE="is_active";
    private static final String ID="id";
    private static final String NAME="name";
    private static final String PRICE="price";
    private static final String PHOTO="photo";
    @Override
    public Menu map(ResultSet resultSet) throws DaoException {
        Menu menu=null;
        try {
            String name=resultSet.getString(NAME);
            String photo=resultSet.getString(PHOTO);
            String price=resultSet.getString(PRICE);
            int id=resultSet.getInt(ID);
            int isActive=resultSet.getInt(IS_ACTIVE);
            menu=new Menu(id,name,price,photo,isActive);
        } catch (SQLException e) {
           throw new DaoException("Result set exception",e);
        }
        return menu;
    }

}
