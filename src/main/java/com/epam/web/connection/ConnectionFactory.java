package com.epam.web.connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    static ProxyConnection createConnection()  {
        //todo properties file
        String url = "jdbc:mysql://localhost:3306/epamweb?useSSL=false&allowPublicKeyRetrieval=true";
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "as122592as");
        properties.put("autoReconnect", "true");
        properties.put("characterEncoding", "UTF-8");
        properties.put("useUnicode", "true");
        ProxyConnection proxyConnection = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            proxyConnection = new ProxyConnection(DriverManager.getConnection(url, properties));
        } catch (SQLException e) {
            //todo log
        }
        return proxyConnection;
    }
}
