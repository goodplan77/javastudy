package com.kh.practice.file.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDAO {

	public boolean checkName(String file) {
		return new File(file).exists();

	}

	public void fileSave(String file, String s) {
		File f = new File(file);
		FileOutputStream fos = null;
		try {
			f.createNewFile();
			fos = new FileOutputStream(f);
			char[] ch = s.toCharArray();
			for (int i = 0; i < s.length(); i++) {
				fos.write(ch[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public StringBuilder fileOpen(String file) {

		FileInputStream fis = null;
		StringBuilder sb = new StringBuilder();

		try {
			fis = new FileInputStream(file);

			int value = 0;
			while ((value = fis.read()) != -1) {
				sb.append((char) value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return sb;

	}

	public void fileEdit(String file, String s) {

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file, true);
			char[] ch = s.toCharArray();
			for (char word : ch) {
				fos.write(word);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
