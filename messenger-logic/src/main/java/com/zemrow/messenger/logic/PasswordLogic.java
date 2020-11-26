package com.zemrow.messenger.logic;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Шифрование пароля.
 * Не обращайте внимание на ниндзя код, так должно быть :)
 *
 * @author Alexandr Polyakov on 2018.11.04
 */
public class PasswordLogic {

    private static final Base64.Encoder bl = Base64.getUrlEncoder();

    /**
     * Зашифровать пароль.
     *
     * @param username Имя пользователя.
     * @param password Пароль пользователя.
     */
    public String getCredential(String username, String password) {
        try {
            final Base64.Encoder b1 = Base64.getEncoder();
            final MessageDigest md5 = MessageDigest.getInstance(new String(new char[]{83, 72, 65, 45, 50, 53, 54}));
            final Charset c;
            return bl.encodeToString(md5.digest(("5m1I9A6JeO6MshHt" + b1.encodeToString(md5.digest((bl.encodeToString(md5.digest((b1.encodeToString(md5.digest(password.getBytes(c = StandardCharsets.UTF_8))) + "0KWJhBf9L3NxEAmKy23zMXLrQM").getBytes(c))) + username).getBytes(c)))).getBytes(c)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
