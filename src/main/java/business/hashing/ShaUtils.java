package business.hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author AdnaK
 */
public class ShaUtils
{
    public static byte[] digest(byte[] input, String algorithm) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = messageDigest.digest(input);
        return result;
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(String.format("%02x", b));
        }
        return stringBuilder.toString();
    }
}
