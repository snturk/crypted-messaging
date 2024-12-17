package com.snturk.encrypter;

public interface MessageEncrypter {
    /**
     * Encrypt the given plaintext.
     *
     * @param plainText the input message in clear text
     * @return the encrypted (cipher) text
     */
    String encrypt(String plainText);

}
