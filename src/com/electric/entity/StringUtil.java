package com.electric.entity;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtil {

	/**
     * 用md5编码后的码值
     *
     * @param sInput
     *            明码
     * @return md5加密后的密码
*/
    public static String getMD5(String sInput) {

        String algorithm = "";
        if (sInput == null) {
            return "null";
        }
        try {
            algorithm = System.getProperty("MD5.algorithm", "MD5");
        } catch (SecurityException se) {
        }
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte buffer[] = sInput.getBytes();

        for (int count = 0; count < sInput.length(); count++) {
            md.update(buffer, 0, count);
        }
        byte bDigest[] = md.digest();
        BigInteger bi = new BigInteger(bDigest);
        return (bi.toString(16));
    }
    
    
    public static void main(String[] args) {
		System.out.println(getMD5("123"));
	}
	  
}
