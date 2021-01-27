package com.epam.web.connection;

import com.epam.web.exceptions.ConnectionException;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    static ProxyConnection createConnection() throws ConnectionException {
        ProxyConnection proxyConnection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/epamweb";
            Properties properties = new Properties();
            properties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream("connection/dbConnection.properties"));
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            proxyConnection = new ProxyConnection(DriverManager.getConnection(url, properties));
        } catch (IOException | SQLException e) {
            throw new ConnectionException(e.getMessage(),e);
        }
        return proxyConnection;
    }
}
