package com.orange.basetool.global.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class SecurityUtil {

    public static String encryPassWord(String password){
        Md5Hash md5Hash = new Md5Hash(password,"orange");
        return md5Hash.toString();
    }
}
