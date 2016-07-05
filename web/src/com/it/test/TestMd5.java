package com.it.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import javax.servlet.http.Part;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Administrator on 2016/6/14.
 */


public class TestMd5 {
    @Test
    public void test() {
        String password = "123";
        //String salt = "adwwafdfefwa";
        String str = DigestUtils.md5Hex(password);
        System.out.println(str);
    }

    @Test
    public void testHex() {
        String i = "110";
        i = DigestUtils.sha1Hex(i);
        System.out.println(i);
    }


    @Test
    public void getName() {
        String header = "filename=\"4a8a8049gw1er0d73tjxgj20j60cstfo.jpg\"";

        header = header.substring(header.indexOf("filename"));
        header = header.substring(header.indexOf("\"") + 1, header.length() - 1);
        System.out.println(header);
    }
}



