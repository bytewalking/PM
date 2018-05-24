package com.suda.zph.passwordmanager.security;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESDemo {
    private static String src = "TestAES";
    public static void jdkAES (){
        try {

            //生成Key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            //keyGenerator.init(128);
            keyGenerator.init(128, new SecureRandom("seedseedseed".getBytes()));
            //使用上面这种初始化方法可以特定种子来生成密钥，这样加密后的密文是唯一固定的。
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] keyBytes = secretKey.getEncoded();

            //Key转换
            Key key = new SecretKeySpec(keyBytes, "AES");

            //加密
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encodeResult = cipher.doFinal(AESDemo.src.getBytes());
            String temp = new String(encodeResult,"ISO-8859-1");
            System.out.println("AESencode : " + temp);

            //解密
            byte[] byteArrays = temp.getBytes("ISO-8859-1");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decodeResult = cipher.doFinal(byteArrays);
            System.out.println("AESdecode : " + new String (decodeResult));


        } catch (NoSuchAlgorithmException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (BadPaddingException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
