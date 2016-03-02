package AES;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class CryptoUtils {
	private static final String ALGORITHM = "AES";
	private static final String TRANSFORMATION = "AES";

	public  int encrypt(String key, File inputFile, File outputFile)
			throws CryptoException {
		return doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
	}

	public  int decrypt(String key, File inputFile, File outputFile)
			throws CryptoException {
		return doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
	}

	private  int doCrypto(int cipherMode, String key, File inputFile,
			File outputFile){
		try {
                    System.out.println("inout file:"+inputFile.getPath() +" : output file:"+outputFile.getPath());
                    if(outputFile.exists()==false)
                    {
                        System.out.println("create output file:"+outputFile.createNewFile());
                    }
                    System.out.println("inout lenght file:"+inputFile.length() +" : output lenght file:"+outputFile.length());
			Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			cipher.init(cipherMode, secretKey);
			
			FileInputStream inputStream = new FileInputStream(inputFile);
                        
			byte[] inputBytes = new byte[(int) inputFile.length()];
			inputStream.read(inputBytes);
			
			byte[] outputBytes = cipher.doFinal(inputBytes);
			
			FileOutputStream outputStream = new FileOutputStream(outputFile);
			outputStream.write(outputBytes);
			
			inputStream.close();
			outputStream.close();
			 System.out.println(" output lenght file:"+outputFile.length());
		} catch (Exception ex) {
                    ex.printStackTrace();
                    return -1;
			
		}
                return 1;
	}
}
