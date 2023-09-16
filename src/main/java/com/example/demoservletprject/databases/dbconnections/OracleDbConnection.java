package com.example.demoservletprject.databases.dbconnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

public class OracleDbConnection {
    private static final OracleDbConnection sqlConnection = new OracleDbConnection();
    private OracleDbConnection(){}
    public static OracleDbConnection getOracleDbConnection(){
        return sqlConnection;
    }
    public static Connection getDBConnection(String dbName) throws SQLException,ClassNotFoundException, SQLTimeoutException {
        String dbDriver = "jdbc:oracle:thin";
        String dbURL = "database-1.ctbbxkbnltgp.us-east-1.rds.amazonaws.com:3306";
        String connectionUrl = dbDriver + ":@//" + dbURL + "/";
        String dbUserName = "admin";
        String dbPassword = "Digital123";
        Class.forName("oracle.jdbc.driver.OracleDriver");
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
