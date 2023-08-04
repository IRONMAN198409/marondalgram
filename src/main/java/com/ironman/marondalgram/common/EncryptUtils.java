package com.ironman.marondalgram.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {
	public static String md5(String message) {
        String resultString = "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            
            byte[] bytes = message.getBytes();
            md.update(bytes);

            byte[] digest = md.digest();

            // byte에 담긴 하나의 값을 16진수 문자로 만듦: 사용하기 편하도록
            for(int i = 0; i < digest.length; i++) {
                resultString += Integer.toHexString(digest[i] & 0xff);    // 2진수로 연산 
            }

        } catch( NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return resultString;
	}
}
