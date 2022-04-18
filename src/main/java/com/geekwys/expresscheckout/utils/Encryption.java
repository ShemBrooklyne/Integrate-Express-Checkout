package com.geekwys.expresscheckout.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public class Encryption {

    private final String ivKey, secretKey;

    public Encryption(String ivKey, String secretKey) {
        this.ivKey = ivKey;
        this.secretKey = secretKey;
    }

    /**
     * bytesToHex - a function to convert encrypted byte to a hexadecimal String
     *
     * @param data byte[]
     * @return string String
     */
    public static String bytesToHex(byte[] data) {
        if (data == null) {
            return null;
        }

        int len = data.length;
        String string = "";
        for (byte datum : data) {
            if ((datum & 0xFF) < 16) {
                string = "%s0%s".formatted(string, Integer.toHexString(datum & 0xFF));
            } else {
                string = string + Integer.toHexString(datum & 0xFF);
            }
        }
        return string;
    }

    /**
     * encrypt - a function to encrypt your string using AES 128 it encrypts to
     * AES 128 if we specify no padding to be done
     *
     * @param plainText String
     * @return String
     */
    public String encrypt(String plainText) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashedIV = digest.digest(this.ivKey.getBytes(StandardCharsets.UTF_8));
        byte[] hashedSecret = digest.digest(this.secretKey.getBytes(StandardCharsets.UTF_8));

        IvParameterSpec IV = new IvParameterSpec(
                bytesToHex(hashedIV).substring(0, 16).getBytes()
        );

        SecretKeySpec secret = new SecretKeySpec(
                bytesToHex(hashedSecret).substring(0, 32).getBytes(),
                "AES"
        );

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secret, IV);
        byte[] encrypted = cipher.doFinal(plainText.getBytes());

        String params = Base64.getEncoder().encodeToString(encrypted);
        return Base64.getEncoder().encodeToString(params.getBytes());
    }

}
