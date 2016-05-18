package com.chen.check_image;

import java.io.File;

public class CheckImage {

	public static void main(String[] args) {
		File file = new File("E:/download_test/pics/1c/1cd5v0uya36wg0rf4fu39dtym.png");  
		boolean result=isImage(file); 
	}

	private static boolean isImage(File file) {
		return false;
	}
}
