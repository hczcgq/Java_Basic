package com.chen.file.split;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.jar.Attributes.Name;

/**
 * 拆分合并文件
 * @author chenguoquan
 *
 */
public class SplitFile {

	private static final int SIZE = 1024 * 1024; // 定义单个文件的大小这里采用1m

	public static void main(String[] args) throws Exception {
		// File file=new File("F:\\java_demo\\CustomViewDemo.zip");
		// splitFile(file);

		File file = new File("F:\\java_demo\\parfiles");
		mergeFile(file);
	}

	/**
	 * 合并文件
	 * 
	 * @param dir
	 * @throws Exception
	 */
	private static void mergeFile(File dir) throws Exception {
		// 读取properties文件的拆分信息
		File[] files = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".properties");
			}
		});
		File file = files[0];
		Properties properties = new Properties();
		FileInputStream inputStream = new FileInputStream(file);
		properties.load(inputStream);
		String fileNameString = properties.getProperty("FileName");
		int splitCount = Integer.parseInt(properties.getProperty("partCount"));
		if (files.length != 1) {
			throw new Exception(dir + ",该目录下没有解析的properties文件或不唯一");
		}
		File[] parFiles = dir.listFiles(new FilenameFilter() {

			public boolean accept(File dir, String name) {
				return name.endsWith(".part");
			}
		});
		List<FileInputStream> al = new ArrayList<FileInputStream>();
		for (int i = 0; i < splitCount; i++) {
			al.add(new FileInputStream(parFiles[i]));
		}
		Enumeration<FileInputStream> enumeration = Collections.enumeration(al);// 构建文件流集合
		SequenceInputStream sequenceInputStream = new SequenceInputStream(
				enumeration); // 将多个流合成序列流
		FileOutputStream outputStream = new FileOutputStream(new File(dir,
				fileNameString));
		byte[] b = new byte[1024];
		int len = 0;
		while ((len = sequenceInputStream.read(b)) != -1) {
			outputStream.write(b, 0, len);
		}
		outputStream.close();
		sequenceInputStream.close();
		inputStream.close();
	}

	/**
	 * 拆分文件
	 * 
	 * @param file
	 */
	private static void splitFile(File file) {
		try {
			FileInputStream inputStream = new FileInputStream(file);
			byte[] b = new byte[SIZE]; // 定义缓冲区
			FileOutputStream outputStream = null;
			int len = 0;
			int count = 0;
			/**
			 * 切割文件时，记录 切割文件的名称和切割的子文件个数以方便合并
			 * 这个信息为了简单描述，使用键值对的方式，用到了properties对象
			 */
			Properties properties = new Properties();
			File dirFile = new File("F:\\java_demo\\parfiles");
			if (!dirFile.exists()) {
				dirFile.mkdirs();
			}
			while ((len = inputStream.read(b)) != -1) {
				outputStream = new FileOutputStream(new File(dirFile, (count++)
						+ ".part"));
				outputStream.write(b, 0, len);
				outputStream.close();
			}
			properties.setProperty("partCount", count + "");
			properties.setProperty("FileName", file.getName());
			outputStream = new FileOutputStream(new File(dirFile, (count++)
					+ ".properties"));
			properties.store(outputStream, "save file info");
			outputStream.close();
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
