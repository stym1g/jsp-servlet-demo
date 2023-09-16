package com.example.demoservletprject.supportedclasses;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GlobalFunctions {
    public static String getHashedPassword(String password){
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
