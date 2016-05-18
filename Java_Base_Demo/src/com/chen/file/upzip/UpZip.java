package com.chen.file.upzip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/**
 * 解压zip文件
 * @author chenguoquan
 *
 */
public class UpZip {

	public static void main(String[] args) throws ZipException, IOException {
		File root = new File("F:\\TestFile");

		if (root.exists() && root.isDirectory()) {
			File[] files = root.listFiles();
			for (int i = 0; i < files.length; i++) {
				System.out.println(files[i].getAbsolutePath());
				upZipFile(files[i], "F:\\TestFile\\");
			}
		}
	}

	private static void upZipFile(File zipFile, String folderPath) throws ZipException, IOException {
		ZipFile zfile = new ZipFile(zipFile);
		Enumeration zList = zfile.entries();
		ZipEntry entry = null;
		byte[] buf = new byte[1024];
		while (zList.hasMoreElements()) {
			entry = (ZipEntry) zList.nextElement();
			String zipEntryName = entry.getName();
			InputStream in = zfile.getInputStream(entry);
			String outPath = (folderPath + zipEntryName).replaceAll("\\*", "/");
			File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
			if (!file.exists()) {
				file.mkdirs();
			}
			if (new File(outPath).isDirectory()) {
				continue;
			}
			OutputStream out = new FileOutputStream(outPath);
			int readLen = 0;
			while ((readLen = in.read(buf, 0, 1024)) != -1) {
				out.write(buf, 0, readLen);
			}
			in.close();
			out.close();
		}
		zfile.close();
	}
}
