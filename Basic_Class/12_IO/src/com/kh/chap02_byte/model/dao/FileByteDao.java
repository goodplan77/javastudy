package com.kh.chap02_byte.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// dao(Data Access Object) : 데이터가 보관되어 있는 공간과 직접 분리해서 데이터를 입출력 하는 클래스
public class FileByteDao {

	// 자바프로그램 -> 외부매체(파일)
	// 출력(OUT) : 프로그램내의 데이터를 파일로 내보내기(파일에 기록)

	public void fileSave() {

		// 외부 매체(File)로 데이터를 1byte단위로 "출력" 하는 스트림
		FileOutputStream fos = null; // 변수 선언 및 명시적 초기화

		try {
			// 1. FileOutputStream 객체 생성
			// 객체생성 == 외부매체와의 스트림 연결.
			// FileOutputStream은 연결하고자 하는 파일이 존재하지 않으면 , "파일 생성" 후 연결함. 존재하면 그냥 연결
			// FileOutputStream("연결하고자 하는 외부매체" , 이어쓰기여부(true/false));
			// true 미 작성시 => 덮어쓰기(기본값)
			// true 작성시 => 이어쓰기
			// 디렉토리 직접 설정 안했으면 현재 프로젝트

			// 1-1) 파일 경로가 이미 준비 되어 있는 경우
			fos = new FileOutputStream("a_byte.txt" , true); // a_byte.txt 이름을 가진 파일과의 스트림 생성 , true로 인해 이어쓰기

			// 1-2) 파일 경로를 따로 설정 해줘야 하는 경우
			// 디렉토리 설정을 따로 해주고 file 객체 생성후 파일 추가?
			/*
			 * String path = "C:/abc"; File dir = new File(path); if(!dir.exists()) {
			 * dir.mkdir(); } fos = new FileOutputStream(new File(path+"/"+"a_byte.txt") ,
			 * true);
			 */

			// 2. 연결통로를 통해 데이터를 "출력" : write() 메소드 사용
			// 1byte 범위 내에서 문자 출력 가능(-128 ~ 127 까지의 숫자만 저장 가능)
			// 파일에 기록시 '문자'로 기록되기 때문에 0~127 까지의 숫자만 저장가능.
			fos.write(97); // 97 =='a'
			fos.write('b'); // 'b' == 98
			fos.write('민'); // 문자열 깨짐 (바이트의 표현범위 벗어남)

			byte[] bArr = { 'a', 'p', 'p', 'l', 'e' }; // apple
			fos.write(bArr);

			byte[] cArr = { 'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd' }; // hello world
			fos.write(cArr, 0, 5);

			fos.write(cArr, 6, 5);
			fos.write('\n'); // 이어쓰기 시 구분을 위한 개행 문자 추가

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} finally { // finally 에러 발생 여부와 상관 없이 "항상" 최종적으로 실행되는 블럭.
			// 3. 스트림을 다 이용했으면 자원 반납하기
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// 외부매체 -> 프로그램 (읽기)
	// 입력 : 파일로부터 현재 어플리케이션에 데이터를 가지고 오기
	public void fileRead() {

		// FileInputStream : 파일로부터 데이터를 1바이트 단위로 입력받는 스트림.
		// try - catch 사용시 주의 -> 선언은 밖에서 실행

		FileInputStream fin = null;

		try {
			// 1. 객체생성 == 외부매체와 스트림을 연결.
			fin = new FileInputStream("a_byte.txt"); // 연결하고자 하는 파일이 없는 경우 에러 발생

			// 2. 스트림을 통해 데이터 입력을 받음 read()
			// 단, 데이터는 1byte 단위로 읽어옴
			
			/*
			System.out.println((char)fin.read());
			System.out.println((char)fin.read());
			System.out.println((char)fin.read());
			System.out.println((char)fin.read());
			System.out.println((char)fin.read());
			System.out.println(fin.read()); // 파일 끝을 만나는 순간 -1 반환
			*/
			
			
			int value = 0;
			
			while((value = fin.read()) != -1) {
				System.out.print((char)value);
			}
			
			/*
			do {
				value = fin.read();
				System.out.print((char) value);
			} while (value != -1);
			*/
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
