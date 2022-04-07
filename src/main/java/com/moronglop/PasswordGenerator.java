package com.moronglop;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawpass = "123456";
        String encodepass = passwordEncoder.encode(rawpass);
        System.out.println(encodepass);
    }
}
