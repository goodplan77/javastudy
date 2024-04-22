package practice01_IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 파일 입출력 시나리오 설정
 * 1. 파일 출력 함수 설정
 * 2. 파일 입력 함수 설정
 * 
 * 버퍼 - 파일 - 바이트 단위 스트림 생성
 */

public class Run {

	public static void main(String[] args) {
		Run run = new Run();
		run.fileSave();
		run.fileRead();
	}

	// 파일 입력 함수
	// 파일 -> 프로그램 저장
	// read , input
	public void fileRead() {

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File("test.txt")));
			String value = "";
			while((value = br.readLine()) != null) {
				System.out.println(value);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

	// 파일 출력 함수
	// 프로그램 -> 파일 저장
	// write , output
	public void fileSave() {
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("test.txt")));
			bw.write("asdf");
			bw.newLine();
			bw.write("asdf");
			bw.newLine();
			bw.write("asdf");
			bw.newLine();
			bw.write("asdf");
			bw.newLine();
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

}
