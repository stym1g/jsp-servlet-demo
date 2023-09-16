package com.example.demoservletprject.databases.dbqueries.sqlqueries;
import com.example.demoservletprject.databases.dbconnections.SQLConnection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLQueries {
    public static String insert(String db, String query) throws SQLException, IOException, SQLTimeoutException {
        String res = null;
        try{
            SQLConnection sqlConnection = SQLConnection.getSQLConnection();
            Connection con = SQLConnection.getDBConnection("todoapp");
            System.out.println("sqlConnection created");
            return null;
        }catch (ClassNotFoundException | SQLTimeoutException e){
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet getRecord(Connection con, String query) {
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<Map<String,Object>> getQueryResult(CallableStatement cs) throws SQLException {
        ResultSet rs = cs.executeQuery();
        List<Map<String,Object>> result = new ArrayList<>();
        while (rs.next()){
            Map<String,Object> row = new HashMap<>();
            for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
                String columnName = rs.getMetaData().getColumnName(i);
                Object columnValue = rs.getObject(i);
                row.put(columnName, columnValue);
            }
            result.add(row);
        }
        rs.close();
        cs.close();
        return result;
    }
}
