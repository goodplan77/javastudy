package com.kh.chap01_URL.part03_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class AirPolution {
	
	/*
	 * URLConnection 활용 예시
	 * 1) 웹크롤링 -> 자주 사용 하진 않음
	 * 2) API서버로 데이터 요청
	 * 	- API서버 ?	쉽게 말하면 내가 URL로 데이터에 대한 요청을 보내면 응답데이터를 반환 해주는 서버
	 * 				단 , 누구나 데이터 요청을 할 수는 없고 , 데이터 요청을 보내기 위해선 API 서버에서
	 * 				정한 "규칙"을 지켜서 요청 해야함
	 * 
	 * 자바	API ? 	자바 애플리케이션 개발을 도와주는 클래스들 (Math , String , Object 등)
	 * 		API ?	Application Programming Interface
	 * 				- 애플리케이션간에 상호작용을 위한 인터페이스
	 * 				- 애플리케이션들중 데이터나 서비스를 제공하는 역할의 애플리케이션을 API 서버라고 부름.
	 * 				- 대표적인 API서버 역할을 하는 애플리케이션 카카오 , 구글 , 네이버등. (sns 로그인할때 많이 사용함)
	 * 				- 이러한 API서버로 데이터나 서비스를 요청하기 위해서는 "규칙"을 지켜서 데이터 요청을 보내야함.
	 * 
	 * API 요청 보내기
	 * 1) 공공데이터 포탈 회원가입
	 * 2) 한국환경공단_에어코리아_대기오염정보 검색
	 * 3) 활용 신청
	 * 4) 마이페이지에서 개인 API인증키 발급 여부 확인
	 * 5) 한국환경공단_에어코리아_대기오염정보 상세 페이지로 이동
	 * 6) 상세기능 아래ㅏ에 목록 선택후 "시도별 실시산 측정정보" 선택후 조회 버튼 클릭 (얻고자 하는 데이터 취사 선택)
	 * 7) 요청주소 , 요청변수 , 출력결과 확인 정보 확인
	 * 8) 요청주소 와 요청 변수를 작성 후 API 서버로 요청(request)
	 * 9) API 서버로부터 응답 결과를 돌려 받기 (response)
	 * 10) 응답데이터를 바탕으로 프로그래밍
	 * 
	 * 요청주소에 요청변수 묶어서 요청 보내기
	 * URL창에서 요청변수는 key=value 형태로 작성. ex) sidoName=서울
	 * 이때 요청변수를 여러개 전달해야하는 경우 &로 이어준다.
	 * 묶어준 요청변수를 요청주소에 이어줄때는 , ?로 요청주소와 요청변수를 구분한다.
	 */
	
	public static void main(String[] args) {
		String requestURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		final String serviceKey = "BZSEc7GLbvkPc7MOf2QZv3JC5dNW%2BA5fB69IoeN%2BAYpw%2BDHhiUXXCYoXqhcbjvLQiydBOSFTf9iYRC44Iddrvg%3D%3D";
		
		// 요청주소 와 요청 변수 묶어주기
		try {
			requestURL += "?serviceKey=" + serviceKey;
			requestURL += "&sidoName=" + URLEncoder.encode("서울","UTF-8");
			/*
			 * URLEncoder.encode("인코딩 필요한 문자열" , "인코딩방식")
			 * URL에서 사용 할 수 없는 문자열을 URL이 해석 할 수 있는 대체 문자열로 반환 하는 함수.
			 * EX)	공백 " " 은 URL 상에서 %20으로 치환됨.
			 * 		그 밖에 한글 과 같은 외국어 + 특수문자가 포함된 경우 인코딩이 필요함
			 */
			URL url = new URL(requestURL);
			
			URLConnection conn = url.openConnection();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new FileWriter("환경오염.xml"));
			
			String line = null;
			while((line = reader.readLine()) != null) {
				writer.write(line);
				writer.write("\n");
				
			}
			
			System.out.println("검색 완료");
			
			reader.close();
			writer.close();
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
