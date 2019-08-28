package com.qf.j1904;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

/**
 * Created by jeffrey on 2019/8/16.
 */
public class TestMd5 {
    @Test
    public  void testmd51(){
        String source = "test2";//源字符串
        Md5Hash md5Hash = new Md5Hash(source);//使用md5加密，加密算法为md5
        String s = md5Hash.toString();//输出16进制字符串
        System.out.println(s);
       // System.out.println(md5Hash.toHex());
        String salt = "abc";
        Md5Hash md5Hash1 = new Md5Hash(source, salt);//带加盐的md5加密
        System.out.println("salt:"+salt+" ="+md5Hash1.toHex());

        int hashIterations = 1;
        Md5Hash md5Hash2 = new Md5Hash(source, salt, 1);//加盐，且迭代n次的md5加密
        System.out.println(md5Hash2.toHex());

        int hashIterations2 = 1024;
        Md5Hash md5Hash3 = new Md5Hash(source, salt, hashIterations2);
        System.out.println(md5Hash3.toHex());

    }
    @Test
    public void  simpleHashTest(){
        String algorithmName = "SHA1";
        String source = "1234";
        String salt ="abc";
        int hashIterations = 1;
        //        简单hash加密
        SimpleHash simpleHash = new SimpleHash(algorithmName,source,salt,hashIterations);
        System.out.println(simpleHash.toHex());
    }
}
