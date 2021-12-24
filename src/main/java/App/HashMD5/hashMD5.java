package App.HashMD5;

import lombok.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class hashMD5 {

    @SneakyThrows
    public static String stringToMD5(String word) {

        byte[] bytesOfWord = word.getBytes(StandardCharsets.UTF_8);
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.reset();
        byte[] theMD5digest = md5.digest(bytesOfWord);

        return bytesToHex(theMD5digest);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}