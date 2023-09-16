package com.example.demoservletprject.servlets;

import com.example.demoservletprject.databases.dbqueries.sqlqueries.procedure.User;
import com.example.demoservletprject.supportedclasses.GlobalFunctions;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Login extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter writer = res.getWriter();
        String userName = req.getParameter("user_name");
        String password = req.getParameter("user_password");
        String hashedPassword = GlobalFunctions.getHashedPassword(password);
        try {
            List<Map<String, Object>> userDetails = User.getUser(userName, null, null, hashedPassword);
            if (userDetails != null && userDetails.size() != 0) {
                for (Map<String, Object> userDetail : userDetails) {
                    if (userDetail.get("username").toString().equals(userName)) {
                        writer.println("<h2>You are logged in</h2>");
                        writer.println("<h2>Welcome " + userDetail.get("Name").toString() + "....;)</h2>");
                        return;
                    }
                }
            }
            writer.println("<h2>Invalid Credentials</h2>");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
