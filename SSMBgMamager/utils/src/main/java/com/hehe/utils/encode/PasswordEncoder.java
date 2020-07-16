package com.hehe.utils.encode;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public static String passwordEncode(String password){
        return passwordEncoder.encode(password);
    }

    public static void main(String[] args) {

        System.out.println(passwordEncode("lb"));
    }
}
