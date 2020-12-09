package com.epam.web.dao.userdao;

import com.epam.web.dao.AbstractDao;
import com.epam.web.dao.mapper.RowMapper;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;

import java.sql.Connection;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final String FIND_BY_LOGIN_AND_PASSWORD = "select * from "+User.TABLE+" u inner join role r on u.role_id=r.id where login=? and password=?";

    public UserDaoImpl(Connection connection) {
        super(connection, RowMapper.createMapper(User.TABLE));
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {
        return executeForSingleResult(FIND_BY_LOGIN_AND_PASSWORD, login, password);
    }

    @Override
    public Optional<User> getById(Long id) {
        return Optional.empty();
        //TODO
    }


    @Override
    public void save(User item) {
        //TODO
    }

    @Override
    public void removeById(Long id) {
        //TODO
    }
}

