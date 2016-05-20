package com.chen.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileUtil {

	public static void main(String[] args) throws IOException {
//		createDirectory("H:\\Text");
		
//		for(int i=0;i<10;i++){
//			createFile("H:\\Text", "test"+i+".html");
//			createFile("H:\\Text", "test"+i+".java");
//		}
		
//		deleteDirectory("H:\\Text", ".java");
	}
	
	
	/**
	 * 创建文件夹
	 * @param dir 指定文件路径
	 */
	public static void createDirectory(String dir){
		File file=new File(dir);
		if(file.exists()){
			return;
		}
		file.mkdir();
	}
	
	/**
	 * 删除指定目录下的指定文件
	 * @param dir    文件目录
	 * @param format 删除文件格式
	 */
	public static void deleteDirectory(String dir,final String format){
		File file=new File(dir);
		if(file.exists()){
			if(file.isDirectory()){
				File[] list=file.listFiles(new FilenameFilter() {
					
					public boolean accept(File arg0, String arg1) {
						return arg1.endsWith(format);
					}
				});
				for(int i=0;i<list.length;i++){
					list[i].delete();
				}
			}
		}
	}

	/**
	 * 创建文件
	 * @param dir      文件被创建的目录
	 * @param fileName 文件名称
	 * @throws IOException
	 */
	public static void createFile(String dir,String fileName) throws IOException{
		File file=new File(dir);
		if(!file.exists()){
			file.mkdir();
		}
		File newFile=new File(dir,fileName);
		newFile.createNewFile();
	}	
}
