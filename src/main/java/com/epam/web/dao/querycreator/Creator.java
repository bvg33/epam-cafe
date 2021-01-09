package com.epam.web.dao.querycreator;

import java.util.Map;

public interface Creator {
    String createInsertQuery(String tableName,Map<String,String> fields);
    String createUpdateQuery(String tableName,Map<String,String> fields);
}
