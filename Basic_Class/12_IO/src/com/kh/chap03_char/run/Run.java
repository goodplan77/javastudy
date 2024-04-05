package com.kh.chap03_char.run;

import com.kh.chap03_char.model.dao.FileCharDAO;

public class Run {

	public static void main(String[] args) {
		/*
		 * "문자 기반 스트림"
		 * 외부 매체를 지정하고 그 외부매체와 연결되는 "2byte"짜리 스트림을 만드는 클래스
		 * xxxWriter / xxxReader
		 */
		
		FileCharDAO fc = new FileCharDAO();
		// fc.fileSave();
		fc.fileRead();

	}

}
