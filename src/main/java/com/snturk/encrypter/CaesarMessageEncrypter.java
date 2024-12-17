package com.snturk.encrypter;

public class CaesarMessageEncrypter implements MessageEncrypter {

    private final int shift;

    public CaesarMessageEncrypter(int shift) {
        this.shift = shift;
    }

    @Override
    public String encrypt(String plainText) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : plainText.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                // Shift character by `shift` positions within [A-Z] or [a-z]
                int offset = (c - base + shift) % 26;
                encrypted.append((char) (base + offset));
            } else {
                encrypted.append(c); // Non-letter characters remain unchanged
            }
        }
        return encrypted.toString();
    }
}

