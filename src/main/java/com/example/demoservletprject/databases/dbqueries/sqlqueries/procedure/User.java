package com.example.demoservletprject.databases.dbqueries.sqlqueries.procedure;

import com.example.demoservletprject.databases.dbconnections.SQLConnection;
import com.example.demoservletprject.databases.dbqueries.sqlqueries.SQLQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private static Connection con;
    private static List<Map<String,Object>> procResult;
    public static List<Map<String,Object>> createUser(String name, String username, String email, String mobile, String password) throws SQLException {
        try{
            con = SQLConnection.getDBConnection("todoapp");
            assert con != null;
            CallableStatement cs = con.prepareCall("{Call sp_create_user(?,?,?,?,?) }");
            cs.setString("name",name);
            cs.setString("username",username);
            cs.setString("email",email);
            cs.setString("mobile",mobile);
            cs.setString("password",password);
            procResult = SQLQueries.getQueryResult(cs);
            System.out.println("createUser store proc executed success");
            con.close();
            System.out.println("Connection Closed");
            return procResult;
        }catch (SQLException | ClassNotFoundException e){
            if (con != null){
                con.close();
            }
            e.printStackTrace();
        }
        return null;
    }

    public static List<Map<String,Object>> getUser(String username, String email, String mobile) throws SQLException {

        try{
            con = SQLConnection.getDBConnection("todoapp");
            assert con != null;
            CallableStatement cs = con.prepareCall("{Call sp_get_user(?,?,?) }");
            cs.setString("usernameValue",username);
            cs.setString("emailValue",email);
            cs.setString("mobileValue",mobile);
            procResult = SQLQueries.getQueryResult(cs);
            System.out.println("createUser store proc executed success");
            con.close();
            System.out.println("Connection Closed");
            return procResult;
        }catch (SQLException | ClassNotFoundException e){
            if(con!=null){
                con.close();
            }
            e.printStackTrace();
        }
        return null;
    }
}
