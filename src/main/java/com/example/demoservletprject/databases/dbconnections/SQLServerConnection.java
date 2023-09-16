package com.example.demoservletprject.databases.dbconnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

public class SQLServerConnection {
    private static final SQLServerConnection sqlConnection = new SQLServerConnection();
    private SQLServerConnection(){}
    public static SQLServerConnection getSQLServerConnection(){
        return sqlConnection;
    }
    public static Connection getDBConnection(String dbName) throws SQLException,ClassNotFoundException, SQLTimeoutException {
        String dbDriver = "jdbc:sqlserver";
        String dbURL = "url:port";
        String connectionUrl = dbDriver + "://" + dbURL + "/";
        String dbUserName = "username";
        String dbPassword = "password";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn;
        try {
            conn = DriverManager.getConnection(connectionUrl + dbName, dbUserName, dbPassword);
            return conn;
        }catch ( SQLTimeoutException e){
            e.printStackTrace();
        }
        return null;
    }
}
