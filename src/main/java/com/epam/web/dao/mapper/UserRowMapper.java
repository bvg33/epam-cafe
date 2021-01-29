package com.epam.web.dao.mapper;

import com.epam.web.entity.Role;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class UserRowMapper implements RowMapper<User> {
    private static final String LOGIN="login";
    private static final String PASSWORD="password";
    private static final String NAME="name";
    private static final String CARD_NUMBER="cardNumber";
    private static final String ID="id";
    private static final String POINTS="points";
    private static final String ROLE="role";
    @Override
    public User map(ResultSet resultSet) throws DaoException {
        User user=null;
        try {
            String login = resultSet.getString(LOGIN);
            String password=resultSet.getString(PASSWORD);
            String name=resultSet.getString(NAME);
            String cardNumber=resultSet.getString(CARD_NUMBER);
            int loyality=resultSet.getInt(POINTS);
            int id=resultSet.getInt(ID);
            String roleString=resultSet.getString(ROLE);
            Role role=Role.valueOf(roleString.toUpperCase());
            user=new User(id,login,password,name,cardNumber,loyality,role);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(),e);
        }
        return user;
    }

}