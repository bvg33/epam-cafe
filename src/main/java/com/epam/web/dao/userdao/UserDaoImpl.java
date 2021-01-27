package com.epam.web.dao.userdao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.dao.AbstractDao;
import com.epam.web.dao.extractor.EntityFieldExtractor;
import com.epam.web.dao.extractor.FieldExtractorFactory;
import com.epam.web.dao.mapper.RowMapper;
import com.epam.web.dao.mapper.RowMapperFactory;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;

import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final String FIND_BY_LOGIN_AND_PASSWORD = "select * from " + User.TABLE + " where login=? and password=SHA1(?) and points>0";
    private static final String FIND_BY_LOGIN = "select * from " + User.TABLE + " where login=?";
    private static final String FIND_USERS_BY_ROLE = "select * from " + User.TABLE + " where role=?";

    public UserDaoImpl(ProxyConnection connection) {
        super(connection, RowMapperFactory.createMapper(User.TABLE), FieldExtractorFactory.createFieldExtractor(User.TABLE),User.TABLE);
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {
        return executeForSingleResult(FIND_BY_LOGIN_AND_PASSWORD, login, password);
    }

    @Override
    public Optional<User> findUserByLogin(String login) throws DaoException {
        return executeForSingleResult(FIND_BY_LOGIN, login);
    }

    @Override
    public List<User> findUsersByRole(String role) throws DaoException {
        return executeQuery(FIND_USERS_BY_ROLE, role);
    }
}

