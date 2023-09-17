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

//    public static void getSecret() {
//
//        String secretName = "rds!db-14df2800-2819-421d-8be7-625d6c52d4d4";
//        Region region = Region.of("us-east-1");
//
//        // Create a Secrets Manager client
//        SecretsManagerClient client = SecretsManagerClient.builder()
//                .region(region)
//                .build();
//
//        GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
//                .secretId(secretName)
//                .build();
//
//        GetSecretValueResponse getSecretValueResponse;
//
//        try {
//            getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
//        } catch (Exception e) {
//            // For a list of exceptions thrown, see
//            // https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
//            throw e;
//        }
//
//        String secret = getSecretValueResponse.secretString();
//
//        // Your code goes here.
//    }
}
