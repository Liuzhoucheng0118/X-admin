package com.lzc;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

public class test {
    @Test
    public void test(){
        String s = DigestUtils.md5DigestAsHex("123".getBytes());

        System.out.println(s);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123123");
        System.out.println(encode);
    }
}
