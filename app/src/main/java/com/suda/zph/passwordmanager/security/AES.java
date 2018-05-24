package com.suda.zph.passwordmanager.security;

import javax.crypto.*;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AES {
    private final String strKey = "myKey20180524";
    private Key generateKey(){
        //生成Key
        try {
            KeyGenerator _generator = KeyGenerator.getInstance( "AES" );
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(strKey.getBytes());
            _generator.init(128,secureRandom);
            return _generator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String AESencryption(String password){
        String encryption_password = null;
        Key key = generateKey();
        //加密
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encodeResult = cipher.doFinal(password.getBytes());
            encryption_password = new String(encodeResult,"ISO-8859-1");
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | NoSuchPaddingException | UnsupportedEncodingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return encryption_password;
    }

    public String AESdecode(String encryption_password){
        String password = null;
        Key key = generateKey();

        try {
            //解密
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] byteArrays = encryption_password.getBytes("ISO-8859-1");
            byte[] decodeResult = cipher.doFinal(byteArrays);
            password=  new String (decodeResult);
        } catch (InvalidKeyException | BadPaddingException | UnsupportedEncodingException | IllegalBlockSizeException | NoSuchPaddingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return password;
    }
}
