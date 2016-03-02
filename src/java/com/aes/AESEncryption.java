/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author user
 */
public class AESEncryption {
    
private static final String ALGORITHM = "AES";
public  String encrypt(String valueToEnc,byte[] keyValue) throws Exception
{ 
    Key key = generateKey(keyValue);
 
    Cipher c = Cipher.getInstance(ALGORITHM); 
    c.init(Cipher.ENCRYPT_MODE, key);
    byte[] encValue = c.doFinal(valueToEnc.getBytes()); 
    String encryptedValue = new BASE64Encoder().encode(encValue);
    return encryptedValue; 
} 

public  String decrypt(String encryptedValue,byte[] keyValue) throws Exception 
{
    Key key = generateKey(keyValue); 
    Cipher c = Cipher.getInstance(ALGORITHM); 
    c.init(Cipher.DECRYPT_MODE, key); 
    byte[] decodedValue = new BASE64Decoder().decodeBuffer(encryptedValue);
    byte[] decValue = c.doFinal(decodedValue); 
    String decryptedValue = new String(decValue); 
    return decryptedValue; 
} 

private  Key generateKey(byte[] keyValue) throws Exception
{ 
    Key key = new SecretKeySpec(keyValue, ALGORITHM);
    //SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
    //key = keyFactory.generateSecret(new DESKeySpec(keyValue)); 
    return key; 
} 
}