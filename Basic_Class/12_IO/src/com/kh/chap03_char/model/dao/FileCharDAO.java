package com.kh.chap03_char.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharDAO {

	// 저장 기능
	public void fileSave() {

		// FileWriter : 파일로 데이터를 2byte단위로 출력하는 스트림
		// try ~ with ~ resource 구문
		// try(스트림 객체 생성; 스트림객체;)
		// 스트림 객체를 try()에 넣어버리면, 스트림 객체 생성 후 블록구문 싱행이 완료될때 알아서 자원을 반납.

		try (FileWriter fw = new FileWriter("b_char.txt")) {

			fw.write("가나다라마바\n");
			fw.write('B');

			char[] cArr = { 'k', 'i', 'w', 'i' };
			fw.write(cArr);

			fw.write(cArr, 0, 3);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 입력 기능
	public void fileRead() {
		try (FileReader fr = new FileReader("b_char.txt")) {
			
			int value = 0;
			while((value = fr.read()) != -1) {
				System.out.print((char)value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
