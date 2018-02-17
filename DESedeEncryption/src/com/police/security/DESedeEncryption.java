package com.police.security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.spec.KeySpec;

public class DESedeEncryption {

    public static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private KeySpec myKeySpec;
    private SecretKeyFactory mySecretKeyFactory;
    private Cipher cipher;
    byte[] keyAsBytes;
    private String myEncryptionKey = "yE54dfwbbYR764UNij86sxh67YRT";
    private String myEncryptionScheme = "DESede";
    SecretKey key;

    public DESedeEncryption() throws Exception {
        this.keyAsBytes = this.myEncryptionKey.getBytes("UTF8");
        this.myKeySpec = new DESedeKeySpec(this.keyAsBytes);
        this.mySecretKeyFactory = SecretKeyFactory.getInstance(this.myEncryptionScheme);
        this.cipher = Cipher.getInstance(this.myEncryptionScheme);
        this.key = this.mySecretKeyFactory.generateSecret(this.myKeySpec);
    }

    public String encrypt(String unencryptedString) {
        String encryptedString = null;
        try {
            this.cipher.init(1, this.key);
            byte[] plainText = unencryptedString.getBytes("UTF8");
            byte[] encryptedText = this.cipher.doFinal(plainText);
            BASE64Encoder base64Encoder = new BASE64Encoder();
            encryptedString = base64Encoder.encode(encryptedText);
        } catch (Exception var6) {
            var6.printStackTrace();
        }
        return encryptedString;
    }

    public String decrypt(String encryptedString) {
        String decryptedText = null;
        try {
            this.cipher.init(2, this.key);
            BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] encryptedText = base64Decoder.decodeBuffer(encryptedString);
            byte[] plainText = this.cipher.doFinal(encryptedText);
            decryptedText = bytes2String(plainText);
        } catch (Exception var6) {
            var6.printStackTrace();
        }
        return decryptedText;
    }

    private static String bytes2String(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bytes.length; ++i) {
            stringBuffer.append((char) bytes[i]);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) throws Exception {
        DESedeEncryption myEncryptor = new DESedeEncryption();
        String stringToEncrypt = "13:04";
        String encrypted = myEncryptor.encrypt(stringToEncrypt);
        System.out.println("Encrypted Value :" + encrypted);
    }

}
