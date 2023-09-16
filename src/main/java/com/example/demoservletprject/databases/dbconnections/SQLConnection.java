package com.example.demoservletprject.databases.dbconnections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
public class SQLConnection {
    private static final SQLConnection sqlConnection = new SQLConnection();
    private SQLConnection(){}
    public static SQLConnection getSQLConnection(){
        return sqlConnection;
    }
    public static Connection getDBConnection(String dbName) throws SQLException,ClassNotFoundException, SQLTimeoutException {
        String dbDriver = "jdbc:mysql";
        String dbURL = "database-1.ctbbxkbnltgp.us-east-1.rds.amazonaws.com:3306";
        String connectionUrl = dbDriver + "://" + dbURL + "/";
        String dbUserName = "admin";
        String dbPassword = "Digital123";
        Class.forName("com.mysql.jdbc.Driver");
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
