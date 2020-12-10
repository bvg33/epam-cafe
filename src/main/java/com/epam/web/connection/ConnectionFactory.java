package com.epam.web.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    static ProxyConnection createConnection()  {
        ProxyConnection proxyConnection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/epamweb";
            Properties properties = new Properties();
            properties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("connection/dbConnection.properties"));
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            proxyConnection = new ProxyConnection(DriverManager.getConnection(url, properties));
        } catch (IOException | SQLException e) {
            e.printStackTrace();//todo log
        }
        return proxyConnection;
    }
}
