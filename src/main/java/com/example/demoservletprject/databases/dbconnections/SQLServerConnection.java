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
        String dbURL = "sqlserver-instance.ctbbxkbnltgp.us-east-1.rds.amazonaws.com:3306";
        String dbUserName = "admin";
        String dbPassword = "admin123";
        String connectionUrl = dbDriver + "://" + dbURL + ";databaseName=" + dbName + ";user=" + dbUserName + ";password=" + dbPassword;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn;
        try {
            conn = DriverManager.getConnection(connectionUrl + ";encrypt=true;trustServerCertificate=true");
            return conn;
        }catch ( SQLTimeoutException e){
            e.printStackTrace();
        }
        return null;
    }
}
