package com.snturk.encrypter;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESMessageEncrypter implements MessageEncrypter {
    // TODO: Store the key and IV securely
    private static final byte[] KEY = new byte[] {
            0x00, 0x01, 0x02, 0x03,
            0x04, 0x05, 0x06, 0x07,
            0x08, 0x09, 0x0A, 0x0B,
            0x0C, 0x0D, 0x0E, 0x0F
    };

    private static final byte[] IV = new byte[] {
            0x0F, 0x0E, 0x0D, 0x0C,
            0x0B, 0x0A, 0x09, 0x08,
            0x07, 0x06, 0x05, 0x04,
            0x03, 0x02, 0x01, 0x00
    };

    @Override
    public String encrypt(String plainText) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(KEY, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(IV);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            byte[] encrypted = cipher.doFinal(plainText.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            throw new RuntimeException("Error while encrypting with AES", e);
        }
    }
}

