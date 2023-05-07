package com.teamchop.chopsticks.util;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

public class Authenticate {
    public static boolean validate(String token){
        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token.substring(7));
            String uid = decodedToken.getUid();
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static String getFirebaseId(String token){
        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token.substring(7));
            String uid = decodedToken.getUid();
            return uid;
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
        }
        return "";
    }
}
