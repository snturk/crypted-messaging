import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.snturk.decrypter.CaesarMessageDecrypter;
import com.snturk.encrypter.CaesarMessageEncrypter;
import com.snturk.decrypter.MessageDecrypter;
import com.snturk.encrypter.MessageEncrypter;
import org.junit.jupiter.api.Test;

class CaesarCipherTest {

    @Test
    void testCaesarCipherEncryptionDecryption() {
        // Given
        MessageEncrypter encrypter = new CaesarMessageEncrypter(3);
        MessageDecrypter decrypter = new CaesarMessageDecrypter(3);
        String originalText = "Hello World!";

        // When
        String encryptedText = encrypter.encrypt(originalText);
        String decryptedText = decrypter.decrypt(encryptedText);

        // Then
        // Ensure encryption actually changes the text
        assertNotEquals(originalText, encryptedText,
                "Encrypted text should not be the same as the original");

        // Ensure decryption recovers the original text
        assertEquals(originalText, decryptedText,
                "Decrypted text should match the original text");
    }

    @Test
    void testEmptyString() {
        MessageEncrypter encrypter = new CaesarMessageEncrypter(5);
        MessageDecrypter decrypter = new CaesarMessageDecrypter(5);

        String originalText = "";

        String encryptedText = encrypter.encrypt(originalText);
        String decryptedText = decrypter.decrypt(encryptedText);

        // With an empty string, both encryption and decryption should yield the same empty string
        assertEquals("", encryptedText, "Encrypted empty string should remain empty");
        assertEquals("", decryptedText, "Decrypted empty string should remain empty");
    }

    @Test
    void testNonAlphabeticCharacters() {
        MessageEncrypter encrypter = new CaesarMessageEncrypter(3);
        MessageDecrypter decrypter = new CaesarMessageDecrypter(3);

        String originalText = "1234!@#$";
        String encryptedText = encrypter.encrypt(originalText);
        String decryptedText = decrypter.decrypt(encryptedText);

        // Non-alphabetic characters should remain unchanged after encrypt/decrypt
        assertEquals(originalText, decryptedText,
                "After encryption and decryption, non-alphabetic characters should remain the same");
    }
}
