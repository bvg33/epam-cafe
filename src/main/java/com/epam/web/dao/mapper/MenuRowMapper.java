package com.epam.web.dao.mapper;

import com.epam.web.entity.Menu;
import com.epam.web.exceptions.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuRowMapper implements RowMapper<Menu> {

    @Override
    public Menu map(ResultSet resultSet) throws DaoException {
        Menu menu=null;
        try {
            String name=resultSet.getString("name");
            String description=resultSet.getString("description");
            String photo=resultSet.getString("photo");
            String price=resultSet.getString("price");
            int id=resultSet.getInt("id");
            menu=new Menu(id,name,description,price,photo);
        } catch (SQLException e) {
           throw new DaoException("Result set exception",e);
        }
        return menu;
    }
}
