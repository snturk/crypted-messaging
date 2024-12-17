package com.snturk.decrypter;

public class CaesarMessageDecrypter implements MessageDecrypter {

    private final int shift;

    public CaesarMessageDecrypter(int shift) {
        this.shift = shift;
    }

    @Override
    public String decrypt(String cipherText) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : cipherText.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                // Reverse the shift
                int offset = (c - base - shift + 26) % 26;
                decrypted.append((char) (base + offset));
            } else {
                decrypted.append(c); // Non-letter characters remain unchanged
            }
        }
        return decrypted.toString();
    }
}
