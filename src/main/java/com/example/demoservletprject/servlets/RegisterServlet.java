package com.example.demoservletprject.servlets;
import com.example.demoservletprject.databases.dbqueries.sqlqueries.procedure.User;
import com.example.demoservletprject.supportedclasses.GlobalFunctions;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter writer = res.getWriter();
        String agreeTerms = req.getParameter("accept_terms");
        System.out.println(agreeTerms);
        if(agreeTerms == null){
            writer.println("<h2>You have not accepted terms</h2>");
            RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
            rd.include(req,res);
        }
        else{
            String fullName = req.getParameter("first_name");
            String lastName = req.getParameter("last_name");
            if(lastName != null && !lastName.trim().isEmpty()){
                fullName += " " + lastName;
            }
            String userName = req.getParameter("user_name");
            String email = req.getParameter("user_email");
            String mobileNo = req.getParameter("user_mobile");
            String password = req.getParameter("user_password");
            String hashedPassword = GlobalFunctions.getHashedPassword(password);
            try{
                List<Map<String,Object>> userDetails = User.getUser(userName, email, mobileNo);
                if(userDetails != null && userDetails.size() != 0){
                    for(Map<String,Object> userDetail : userDetails ){
                        if(userDetail.get("username").toString().equals(userName)){
                            writer.println("<h2>User Name " + userName + " Already Exists. Choose different username</h2>");
                            return;
                        }
                        if(userDetail.get("mobile").toString().equals(mobileNo)){
                            writer.println("<h2>Mobile Number " + mobileNo + " Already Exists. Choose different.</h2>");
                            return;
                        }
                        if(userDetail.get("email").toString().equals(email)){
                            writer.println("<h2>Email " + email + " Already Exists. Choose different</h2>");
                            return;
                        }
                    }
                    writer.println("<h2>User Already Exists</h2>");
                    return;
                }

                List<Map<String,Object>> createUserResult = User.createUser(fullName, userName, email, mobileNo, hashedPassword);
                writer.println("<h2>You have Registered now</h2>");
                writer.println("<h2>Name: " + fullName + "</h2>");
                writer.println("<h2>Email: " + email + "</h2>");
                writer.println("<h2>User Name: " + userName + "</h2>");
                writer.println("<h2>Mobile Number: " + mobileNo + "</h2>");
            }catch (SQLException e){
                e.printStackTrace();
                writer.println("<h2>An Error occured</h2>");
            }

        }

    }
}
