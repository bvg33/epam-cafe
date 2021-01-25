package com.epam.web.dao.mapper;

import com.epam.web.entity.Role;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User map(ResultSet resultSet) throws DaoException {
        User user=null;
        try {
            String login = resultSet.getString("login");
            String password=resultSet.getString("password");
            String name=resultSet.getString("name");
            String cardNumber=resultSet.getString("cardnumber");
            int loyality=resultSet.getInt("points");
            int id=resultSet.getInt("id");
            String roleString=resultSet.getString("role");
            Role role=Role.valueOf(roleString.toUpperCase());
            user=new User(id,login,password,name,cardNumber,loyality,role);
        } catch (SQLException e) {
            throw new DaoException("Result set exception");
        }
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }
}