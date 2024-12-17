import com.snturk.decrypter.AESMessageDecrypter;
import com.snturk.decrypter.MessageDecrypter;
import com.snturk.encrypter.AESMessageEncrypter;
import com.snturk.encrypter.MessageEncrypter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AESCryptoTest {

    @Test
    void testEncryptionDecryption() {
        MessageEncrypter encrypter = new AESMessageEncrypter();
        MessageDecrypter decrypter = new AESMessageDecrypter();

        String original = "Hello AES Encryption!";

        // Encrypt the original text
        String encrypted = encrypter.encrypt(original);
        assertNotNull(encrypted, "Encrypted text should not be null");
        assertNotEquals(original, encrypted, "Encrypted text should not match the original plaintext");

        // Decrypt the encrypted text
        String decrypted = decrypter.decrypt(encrypted);
        assertNotNull(decrypted, "Decrypted text should not be null");
        assertEquals(original, decrypted, "Decrypted text should match the original plaintext");
    }

    @Test
    void testEmptyString() {
        MessageEncrypter encrypter = new AESMessageEncrypter();
        MessageDecrypter decrypter = new AESMessageDecrypter();

        String original = "";
        String encrypted = encrypter.encrypt(original);
        String decrypted = decrypter.decrypt(encrypted);

        assertEquals("", decrypted, "Empty string should be recovered unchanged");
    }

    @Test
    void testNonAlphanumericCharacters() {
        MessageEncrypter encrypter = new AESMessageEncrypter();
        MessageDecrypter decrypter = new AESMessageDecrypter();

        String original = "Special chars: !@#$%^&*()_+[]{};':\",.<>?";
        String encrypted = encrypter.encrypt(original);
        String decrypted = decrypter.decrypt(encrypted);

        assertEquals(original, decrypted, "Decrypted text should match original with special characters");
    }
}
