package com.cardcoupon.passbook.security;

/**
 * <h1>use ThreadLocal to store the token header info a thread is carried</h1>
 * Created by Di Lu
 */
public class AccessContext {
    private static final ThreadLocal<String> token = new ThreadLocal<>();

    /**
     * Getter of the ThreadLocal token
     * @return the String header
     */
    public static String getToken() {
        return token.get();
    }

    /**
     * Setter for the ThreadLocal token
     * @param tokenString the string to be put in
     */
    public static void setToken(String tokenString) {
        token.set(tokenString);
    }

    /**
     * the function to destroy the ThreadLocal token
     */
    public static void clearAccessKey(){
        token.remove();
    }
}
