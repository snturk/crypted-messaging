package com.snturk.decrypter;

public interface MessageDecrypter {
    /**
     * Decrypt the given ciphertext.
     *
     * @param cipherText the encrypted message
     * @return the original plaintext
     */
    String decrypt(String cipherText);
}
