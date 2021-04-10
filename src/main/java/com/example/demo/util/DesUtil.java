package com.example.demo.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DesUtil {
	private final static String encoding = "utf-8";
	
	private static String getIVToday(){
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}
	private static String getIVYesterday(){
		return new SimpleDateFormat("yyyyMMdd").format(new Date(new Date().getTime()-86400000));
	}
	
	private static String getIVTomorrow(){
		return new SimpleDateFormat("yyyyMMdd").format(new Date(new Date().getTime()+86400000));
	}
	
	private static String getSecretKeyToday(){
		return "cmcc_"+getIVToday()+"_asiainfo_ocs";
	}
	
	private static String getSecretKeyYesterday(){
		return "cmcc_"+getIVYesterday()+"_asiainfo_ocs";
	}
	
	private static String getSecretKeyTomorrow(){
		return "cmcc_"+getIVTomorrow()+"_asiainfo_ocs";
	}
	
	/**
	 * 鍔犲瘑
	 * @param plainText
	 * @return
	 */
	public static String encode(String plainText) {
		Key deskey = null;
		byte[] encryptData = null;
		String secretKey = getSecretKeyToday();
		try {
			DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
			SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
			deskey = keyfactory.generateSecret(spec);

			Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
			IvParameterSpec ips = new IvParameterSpec(getIVToday().getBytes());
			cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
			encryptData = cipher.doFinal(plainText.getBytes(encoding));
			
			BASE64Encoder base64Encoder = new BASE64Encoder();
	        return base64Encoder.encode(encryptData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 瑙ｅ瘑
	 * @param data
	 * @return
	 */
	public static String decode(String data){
		try {
			Key deskey = null;
			String secretKey = getSecretKeyToday();
			DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
			SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
			deskey = keyfactory.generateSecret(spec);
			Cipher deCipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
			IvParameterSpec ips = new IvParameterSpec(getIVToday().getBytes());
			deCipher.init(Cipher.DECRYPT_MODE, deskey, ips);
			
			BASE64Decoder base64Decoder = new BASE64Decoder();
			byte[] pasByte = null;
			try{
				pasByte=deCipher.doFinal(base64Decoder.decodeBuffer(data));
			}catch(BadPaddingException e){
				secretKey = getSecretKeyYesterday();
				spec = new DESedeKeySpec(secretKey.getBytes());
				deskey = keyfactory.generateSecret(spec);
				ips = new IvParameterSpec(getIVYesterday().getBytes());
				deCipher.init(Cipher.DECRYPT_MODE, deskey, ips);
				try{
					pasByte=deCipher.doFinal(base64Decoder.decodeBuffer(data));
				}catch(BadPaddingException e1){
					secretKey = getSecretKeyTomorrow();
					spec = new DESedeKeySpec(secretKey.getBytes());
					deskey = keyfactory.generateSecret(spec);
					ips = new IvParameterSpec(getIVTomorrow().getBytes());
					deCipher.init(Cipher.DECRYPT_MODE, deskey, ips);
					
					pasByte=deCipher.doFinal(base64Decoder.decodeBuffer(data));
				}
			}
			return new String(pasByte,"UTF-8");
		} catch (Exception e) {}
		return "";
    }


}
