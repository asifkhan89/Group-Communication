/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SHA;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class GenHashhh {

    public String hash;

    public String sha1(File file) throws NoSuchAlgorithmException, IOException {
        final MessageDigest messageDigest = MessageDigest.getInstance("SHA1");

       
            InputStream is = new BufferedInputStream(new FileInputStream(file));
            final byte[] buffer = new byte[1024];
            for (int read = 0; (read = is.read(buffer)) != -1;) {
                messageDigest.update(buffer, 0, read);
            }
        
        // Convert the byte to hex format
        
            Formatter formatter = new Formatter();
            for (final byte b : messageDigest.digest()) {
                formatter.format("%02x", b);
            }
            hash = formatter.toString();
            System.out.println("" + formatter.toString());
            return formatter.toString();
        }
   

//    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
//        File file = new File("C:\\Users\\Yatin\\Desktop\\Input\\encrypted.mp4");
//        GenHashhh.sha1(file);
//    }
}
