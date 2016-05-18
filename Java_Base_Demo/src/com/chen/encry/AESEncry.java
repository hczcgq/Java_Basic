package com.chen.encry;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

/**
 * AES加密解密
 * @author windows
 *
 */
public class AESEncry {

	public static void main(String[] args) {
		System.out.println(encrypt());
		System.out.println(desEncrypt(encrypt()));
	}

	/**
	 * 加密
	 * @return
	 */
	private static String encrypt() {
		try {
			String data = "cgq123456";
			String key = "1234567812345678";
			String iv = "1234567812345678";
			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			int blockSize = cipher.getBlockSize();
			byte[] dataBytes = data.getBytes();
			int plaintextLength = dataBytes.length;
			if (plaintextLength % blockSize != 0) {
				plaintextLength = plaintextLength
						+ (blockSize - (plaintextLength % blockSize));
			}
			byte[] plaintext = new byte[plaintextLength];
			System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

			SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
			IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
			cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
			byte[] encrypted = cipher.doFinal(plaintext);
			return new BASE64Encoder().encode(encrypted);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 解密
	 * @param string
	 * @return
	 */
	public static String desEncrypt(String string) {
		try {
			String key = "1234567812345678";
			String iv = "1234567812345678";
			byte[] encrypted1 = new BASE64Decoder().decodeBuffer(string);

			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
			IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

			cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
			byte[] original = cipher.doFinal(encrypted1);
			String originalString = new String(original);
			return originalString;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
