package com.epam.web.dao.mapper;

import com.epam.web.entity.Menu;
import com.epam.web.exceptions.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class MenuRowMapper implements RowMapper<Menu> {
    @Override
    public Menu map(ResultSet resultSet) throws DaoException {
        Menu menu=null;
        try {
            String name=resultSet.getString("name");
            String photo=resultSet.getString("photo");
            String price=resultSet.getString("price");
            int id=resultSet.getInt("id");
            int isActive=resultSet.getInt("is_active");
            menu=new Menu(id,name,price,photo,isActive);
        } catch (SQLException e) {
           throw new DaoException("Result set exception",e);
        }
        return menu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }
}
