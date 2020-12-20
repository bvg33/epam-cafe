package com.epam.web.dao.menudao;

import com.epam.web.dao.AbstractDao;
import com.epam.web.dao.mapper.RowMapper;
import com.epam.web.entity.Menu;

import java.sql.Connection;
import java.util.Optional;

public class MenuDaoImpl extends AbstractDao<Menu>  {

    public MenuDaoImpl(Connection connection) {
        super(connection, RowMapper.createMapper(Menu.TABLE));
    }

    @Override
    public Optional<Menu> getById(Long id) {
        return Optional.empty();//todo
    }

    @Override
    public void save(Menu item) {
        //todo
    }

    @Override
    public void removeById(Long id) {
        //todo
    }

}
