package hr.ibs.bank.helpers;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CryptHelpers {

    public static String sha(String plainText) {
        try {

            MessageDigest crypt = MessageDigest.getInstance("SHA-1");

            return Base64.getEncoder().encodeToString((crypt.digest(plainText.getBytes("UTF-8"))));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
