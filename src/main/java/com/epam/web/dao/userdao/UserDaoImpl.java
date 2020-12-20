package com.epam.web.dao.userdao;

import com.epam.web.dao.AbstractDao;
import com.epam.web.dao.mapper.RowMapper;
import com.epam.web.dao.parser.EntityFieldExtractor;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final String FIND_BY_LOGIN_AND_PASSWORD = "select * from " + User.TABLE + " u inner join role r on u.role_id=r.id where login=? and password=?";
    private static final String FIND_BY_LOGIN = "select * from " + User.TABLE + " u inner join role r on u.role_id=r.id where login=?";
    private final EntityFieldExtractor<User> fieldExtractor = EntityFieldExtractor.createFieldExtractor(User.TABLE);

    public UserDaoImpl(Connection connection) {
        super(connection, RowMapper.createMapper(User.TABLE));
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
    public void save(User item) throws DaoException {
        String updateQuery = "update " + User.TABLE + " set name=?,login=?,cardnumber=? where id=?";
        EntityFieldExtractor userEntityFieldExtractor = EntityFieldExtractor.createFieldExtractor(User.TABLE);
        Map<String, String> fields = userEntityFieldExtractor.parse(item);
        String newName=fields.get("name");
        String newLogin=fields.get("login");
        String newCardNumber=fields.get("cardNumber");
        int id=item.getId();
        executeUpdate(updateQuery,newName,newLogin,newCardNumber,id);
    }

    @Override
    public Optional<User> getById(Long id) {
        return Optional.empty();
        //TODO
    }

    @Override
    public void removeById(Long id) {
        //TODO
    }
}

