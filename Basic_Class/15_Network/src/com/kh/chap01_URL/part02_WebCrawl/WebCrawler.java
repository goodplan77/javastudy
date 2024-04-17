package com.kh.chap01_URL.part02_WebCrawl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * URL을 활용한 웹크롤링
 * 웹 크롤링?
 * 웹페이지를 탐색하여 정보를 수집하는 프로그램. 다양한 웹 페이지를 방문하고 내용을 분석하여 필요한 정보만 추출하는 자동화기법
 * 단 , 웹페이지 소유주나 운영자의 동의 없이 크롤링 하는 경우 법적책임이 따름
 */
public class WebCrawler {
	
	// 웹 크로링 할 주소 : https://khedu.co.kr/project/team.kh
	
	// 주소에서 이미지들만 수집하는 크롤러
	public void WebCrawling() {
		// html 페이지 내에서 이미지는 <img src="이미지주소"> 식으로 생김
		
		/*
		 * 일반적인 웹 크롤링 방법
		 * 1) 내가 수집하고자 하는 데이터가 존재하는 페이지에서 각각의 데이터들이 가지는 고유한 특징 확인
		 * 	<img src="이미지주소">
		 * 
		 * 2) URL을 통해 페이지와 연결하고 페이지 전체 정보를 저장
		 * 
		 * 3) 저장된 정보("문자열") 에서 내부에 <img src="이미지주소"> 포함된 문자열을 모두 저장.
		 * 
		 * 4) 이러한 특정 문자열 패턴 안의 데이터만 가져오기 위해서는 정규식 이란 것을 사용
		 * 	정규식 ? 문자열 내부에서 특정 "패턴"을 찾아내기 위한 효과적인 방법
		 * 			aa1bb2cc3ddee :	1b 2c 3d 들과 같이 영문자 앞에 숫자가 포함된 형태의 문자들을 찾으려면?
		 * 							정규식을 통해 문자열 패턴은 숫자+문자로 구성되어있다. 라고 표현식을 세우면됨.
		 * 							정규식에서 숫자를 의미하는 패턴은 \d , 문자를 의미하는 패턴은 \w
		 * 							\d\w
		 * 5) <img src="이미지주소"> 내부의 데이터만 가져 오기 위한 정규식 ? <img\\s+src=\"([^\"]+)\"
		 */
		
		ArrayList<String> imgList = new ArrayList<>();
		
		for(int pageNum = 1 ; pageNum <=44 ; pageNum++) {
			String address = "https://khedu.co.kr/project/team.kh?cpage=" + pageNum;
			BufferedReader reader = null;
			
			try {
				URL url = new URL(address);
				URLConnection conn = url.openConnection();
				reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				// HTML 페이지의 내용을 담을 문자열 변수
				StringBuilder htmlContent = new StringBuilder();
				
				String line = null;
				while((line = reader.readLine()) != null) {
					htmlContent.append(line).append("\n");
				}
				
				String regex = "<img\\s+src=\"([^\"]+)\""; //사용할 정규표현식
				Pattern pattern = Pattern.compile(regex); // 정규표현식을 사용 할 수 있는 객체
				Matcher matcher = pattern.matcher(htmlContent); // 일치하는 문자열 검사
				
				while(matcher.find()) { //일치하는 문자열을 찾을때마다 반복
					String imageUrl = matcher.group(1); // 매칭되는 문자열 반환
					if(imageUrl.contains("/upload/project")) {
						System.out.println("Image Url : " + imageUrl);
						imgList.add(imageUrl);
					}
					
				}
				
				System.out.println("검색 완료");

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		fileSave(imgList); // 검색내용 전달.
		
	}
	
	public void fileSave(List<String> imageList) {
		for(String imagePath : imageList) {
			// /upload/project/2021090914341787_1.jpg -> /2021090914341787_1.jpg
			String fileName = imagePath.substring(imagePath.lastIndexOf("/"));
			String savePath = "C:/upload/project" + fileName; // 저장할 파일 경로 선언
			
			try {
				URL url = new URL("https://khedu.co.kr" + imagePath);
				URLConnection conn = url.openConnection();
				
				try(BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(savePath));
						BufferedInputStream in = new BufferedInputStream(conn.getInputStream());) {
					int byteRead;
					while((byteRead = in.read()) != -1) {
						out.write(byteRead);
					}
				}
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
