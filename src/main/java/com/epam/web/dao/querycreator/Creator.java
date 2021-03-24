package com.epam.web.dao.querycreator;

import java.util.Map;

public interface Creator {
    /**
     * Method to dynamically create insert query
     * @param tableName name of table in data base
     * @param fields fields of entity
     * @return stringify query
     */
    String createInsertQuery(String tableName,Map<String,String> fields);

    /**
     * Method to dynamically create update query
     * @param tableName name of table in data base
     * @param fields fields of entity
     * @return stringify query
     */
    String createUpdateQuery(String tableName,Map<String,String> fields);
}
