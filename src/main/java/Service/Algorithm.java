package Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

//Esta clase tiene el metodo para encriptar y el metodo para desencriptar las lineas de texto
public class Algorithm {
    
    private static SecretKeySpec secretKey;
    private static byte[] key;

    public static void setKey(final String myKey) {
      MessageDigest sha = null;
      try {
        key = myKey.getBytes("UTF-8");
        sha = MessageDigest.getInstance("SHA-1");
        key = sha.digest(key);
        key = Arrays.copyOf(key, 16);
        secretKey = new SecretKeySpec(key, "AES");
      } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
        e.printStackTrace();
      }
    }

    public static String encryptTL(final String strToEncrypt, final String key) {
      try {
        setKey(key);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder()
          .encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
      } catch (Exception e) {
        System.out.println("Error while encrypting: " + e.toString());
      }
      return null;
    }

    public static String decryptTL(final String strToDecrypt, final String key) {
      try {
        setKey(key);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder()
          .decode(strToDecrypt)));
      } catch (Exception e) {
        System.out.println("Error while decrypting: " + e.toString());
      }
      return null;

    }

}
