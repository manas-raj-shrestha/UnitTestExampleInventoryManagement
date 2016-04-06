package com.leapfrog.inventorymanagementsystem.api;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Created by laaptu on 4/6/16.
 */
public class ApiUtils {

    private static String UTF_8 = "UTF-8";

    //https://en.wikipedia.org/wiki/Basic_access_authentication
    public static String generateBasicAuthHeader(String username, String password) {
        String mainString = username + ":" + password;
        try {
            byte[] bytes = mainString.getBytes(UTF_8);
            String base64String = Base64.encodeToString(bytes, Base64.CRLF).replaceAll("\r\n","");
            return "Basic ".concat(base64String);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unable to convert string to bytes with UTF-8 encoding");
        }

    }
}
