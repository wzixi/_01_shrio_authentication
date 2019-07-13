package com.qf.test;

import org.apache.shiro.crypto.hash.Md5Hash;

public class TestMd5 {
    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123");
        //获取加密算法名称
        System.out.println(md5Hash.getAlgorithmName());
        System.out.println(new String(md5Hash.getBytes()));
        System.out.println(md5Hash.toString());
        Md5Hash md5Hash1 = new Md5Hash("123", "qf", 2);
        System.out.println(md5Hash1.toString());
    }
}
