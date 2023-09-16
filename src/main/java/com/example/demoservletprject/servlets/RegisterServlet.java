package com.example.demoservletprject.servlets;
import com.example.demoservletprject.databases.dbqueries.sqlqueries.procedure.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            String hashedPassword = getHashedPassword(password);
            try{
                List<Map<String,Object>> userDetails = User.getUser(userName, email, mobileNo);
                if(userDetails != null && userDetails.size() != 0){
                    for(Map<String,Object> userDetail : userDetails ){
                        if(userDetail.get("username").toString().equals(userName)){
                            writer.println("<h2>User Name " + userName + " Already Exists. Choose different username</h2>");
                        }else if(userDetail.get("mobile").toString().equals(mobileNo)){
                            writer.println("<h2>Mobile Number " + mobileNo + " Already Exists. Choose different.</h2>");
                        }else if(userDetail.get("email").toString().equals(email)){
                            writer.println("<h2>Email " + email + " Already Exists. Choose different</h2>");
                        }
                    }
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

    private String getHashedPassword(String password){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<bytes.length;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        }catch (NoSuchAlgorithmException ex){
            Logger.getLogger("SHA-1").log(Level.SEVERE,null,ex);
            return null;
        }
    }
}
