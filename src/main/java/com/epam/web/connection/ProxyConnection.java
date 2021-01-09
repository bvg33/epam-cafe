package com.epam.web.connection;

import com.epam.web.exceptions.ConnectionException;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class ProxyConnection implements Connection {
    private final Connection connection;

    ProxyConnection(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Statement createStatement() throws ConnectionException {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            throw new ConnectionException("create statement exception",e);
        }
    }

    void closeConnection() throws ConnectionException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new ConnectionException("Close connection exception",e);
        }
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws ConnectionException {
        try {
            return connection.prepareStatement(sql);
        } catch (SQLException e) {
            throw new ConnectionException("Prepare Statement exception",e);
        }
    }

    @Override
    public CallableStatement prepareCall(String sql) {
        return null;
    }
    

    @Override
    public String nativeSQL(String sql) {
        return null;
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws ConnectionException {
        try {
            connection.setAutoCommit(autoCommit);
        } catch (SQLException e) {
            throw new ConnectionException("set auto commit exception",e);
        }
    }

    @Override
    public boolean getAutoCommit() throws ConnectionException {
        try {
            return connection.getAutoCommit();
        } catch (SQLException e) {
            throw new ConnectionException("set auto commit exception",e);
        }
    }

    @Override
    public void commit() throws ConnectionException {
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new ConnectionException("commit exception",e);
        }
    }

    @Override
    public void rollback() throws ConnectionException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new ConnectionException("rollback exception",e);
        }
    }

    @Override
    public void close()  {
        ConnectionPool.getInstance().releaseConnection(this);
    }

    @Override
    public boolean isClosed() throws ConnectionException {
        try {
            return connection.isClosed();
        } catch (SQLException e) {
            throw new ConnectionException("isClosed connection exception",e);
        }
    }

    @Override
    public DatabaseMetaData getMetaData() {
        return null;
    }

    @Override
    public void setReadOnly(boolean readOnly)  {

    }

    @Override
    public boolean isReadOnly()  {
        return false;
    }

    @Override
    public void setCatalog(String catalog) {

    }

    @Override
    public String getCatalog()  {
        return null;
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        connection.setTransactionIsolation(level);
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        return connection.getTransactionIsolation();
    }

    @Override
    public SQLWarning getWarnings() {
        return null;
    }

    @Override
    public void clearWarnings()  {

    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency)  {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)  {
        return null;
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)  {
        return null;
    }

    @Override
    public Map<String, Class<?>> getTypeMap() {
        return null;
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map)  {

    }

    @Override
    public void setHoldability(int holdability)  {

    }

    @Override
    public int getHoldability()  {
        return 0;
    }

    @Override
    public Savepoint setSavepoint() {
        return null;
    }

    @Override
    public Savepoint setSavepoint(String name){
        return null;
    }

    @Override
    public void rollback(Savepoint savepoint)  {

    }

    @Override
    public void releaseSavepoint(Savepoint savepoint)  {

    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)  {
        return null;
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)  {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames)  {
        return null;
    }

    @Override
    public Clob createClob()  {
        return null;
    }

    @Override
    public Blob createBlob() {
        return null;
    }

    @Override
    public NClob createNClob()  {
        return null;
    }

    @Override
    public SQLXML createSQLXML() {
        return null;
    }

    @Override
    public boolean isValid(int timeout) {
        return false;
    }

    @Override
    public void setClientInfo(String name, String value)  {

    }

    @Override
    public void setClientInfo(Properties properties)  {

    }

    @Override
    public String getClientInfo(String name)  {
        return null;
    }

    @Override
    public Properties getClientInfo()  {
        return null;
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) {
        return null;
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes)  {
        return null;
    }

    @Override
    public void setSchema(String schema)   {

    }

    @Override
    public String getSchema()   {
        return null;
    }

    @Override
    public void abort(Executor executor) {

    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds)  {

    }

    @Override
    public int getNetworkTimeout(){
        return 0;
    }

    @Override
    public <T> T unwrap(Class<T> iface)  {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface)  {
        return false;
    }
}