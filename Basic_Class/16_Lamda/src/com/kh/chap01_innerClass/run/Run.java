package com.kh.chap01_innerClass.run;

import com.kh.chap01_innerClass.part01_instance.OuterClass;
import com.kh.chap01_innerClass.part02_static.model.dto.KakaoUserInfoResponse;
import com.kh.chap01_innerClass.part02_static.model.vo.Member;


public class Run {

	public static void main(String[] args) {
		/*
		 * 내부 클래스?
		 * -	외부 클래스 내부에 작성한 클래스를 내부 클래스 라고 부름
		 * -	내부 클래스는 보통 외부 클래스와 밀접한 관련이 있으면서 다른 클래스 들과는
		 * 		서로 연관관계가 없는 경우 , 내부클래스로 선언하여 사용함.
		 * 
		 * 내부 클래스의 종류 ?
		 * 1)	인스턴스 내부 클래스
		 * 2)	정적 내부 클래스 (자주 사용됨)
		 * 3)	지역 내부 클래스
		 * 4)	익명 내부 클래스
		 */
		
		OuterClass oc = new OuterClass();
		System.out.println(oc.staticOuterSTR);
		// oc.new Inner(); Inner가 public 제한자이면 외부 클래스에서 Inner 생성자에 접근 가능함.
		// System.out.println(OuterClass.Inner.sNum); // 에러
		
		
		KakaoUserInfoResponse response = new KakaoUserInfoResponse();
		response.setId(135469842654L);
		response.setHas_signed_up(true);
		KakaoUserInfoResponse.KakaoAccount kakaoAccount = new KakaoUserInfoResponse.KakaoAccount();
		kakaoAccount.setEmail("asdf@naver.com");
		kakaoAccount.setProfile_needs_agreement(true);
		response.setKakao_account(kakaoAccount);
		
		Member m = new Member.Builder("goodplan77")
					.name("경호")
					.age(20)
					.phone(1234)
					.build();
		
		System.out.println(m);
		

	}

}
