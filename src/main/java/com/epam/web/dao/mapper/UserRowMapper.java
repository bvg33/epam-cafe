package com.epam.web.dao.mapper;

import com.epam.web.entity.Role;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User map(ResultSet resultSet) throws DaoException {
        User user=null;
        try {
            String login = resultSet.getString("login");
            String password=resultSet.getString("password");
            String name=resultSet.getString("name");
            String cardNumber=resultSet.getString("cardnumber");
            int loyality=resultSet.getInt("loyality");
            int id=resultSet.getInt("id");
            String roleString=resultSet.getString("role_value");
            Role role=Role.valueOf(roleString.toUpperCase());
            user=new User(id,login,password,name,cardNumber,loyality,role);
        } catch (SQLException e) {
            throw new DaoException("Result set exception");
        }
        return user;
    }
}