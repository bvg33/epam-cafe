package com.epam.web.dao.menudao;

import com.epam.web.connection.ProxyConnection;
import com.epam.web.dao.AbstractDao;
import com.epam.web.dao.extractor.FieldExtractorFactory;
import com.epam.web.dao.mapper.RowMapperFactory;
import com.epam.web.entity.Menu;
import com.epam.web.entity.User;
import com.epam.web.exceptions.DaoException;

import java.util.HashMap;
import java.util.Map;


public class MenuDaoImpl extends AbstractDao<Menu>  {

    public MenuDaoImpl(ProxyConnection connection) {
        super(connection, RowMapperFactory.createMapper(Menu.TABLE), FieldExtractorFactory.createFieldExtractor(Menu.TABLE),Menu.TABLE);
    }
    /*private static final String SAVE_QUERY="insert into "+Menu.TABLE+" (name,description,price,photo) values (?,?,?,?)";
    private static final String DELETE_QUERY="DELETE FROM "+Menu.TABLE+" WHERE id=?";
    @Override
    public void save(Menu item) throws DaoException {
        String description=item.getDescription();
        String name=item.getName();
        String photo=item.getPhoto();
        String price=item.getPrice();
        executeUpdate(SAVE_QUERY,name,description,price,photo);
    }

    @Override
    public void removeById(Long id) throws DaoException {
        executeUpdate(DELETE_QUERY,id);
    }*/

}
