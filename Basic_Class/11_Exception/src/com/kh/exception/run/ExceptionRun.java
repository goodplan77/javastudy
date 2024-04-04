package com.kh.exception.run;

import com.kh.exception.controller.A_UncheckedException;
import com.kh.exception.controller.B_CheckedException;
import com.kh.exception.controller.C_CustomException;

public class ExceptionRun {

	public static void main(String[] args) {
		/*
		 * 에러(오류) 종류
		 * - 시스템 에러 => 컴퓨터 오작동으로 인해 발생 => 소스코드로 해결 안됨. 심각한 에러.
		 * - 컴파일 에러 => 소스코드 상 문법적인 문제로 발생하는 에러. => 소스코드 수정으로 해결됨. (IDE에서 빨간줄로 오류 알려줌)
		 * - 런타임 에러 => 소스코드상 문제 없음. 프로그램 실행도중 발생하는 예외 => 사용자의 잘못된 사용 혹은 개발자의 실수로 인해 발생
		 * - 논리 에러 => 소스코드상으로 문제 없음. 런타임 에서도 문제없음 => 프로그램 의도상 맞지 않는 기능이 실행되는 경우.
		 * 
		 * 시스템 에러를 제외한 컴파일 , 런타임 , 논리 에러와 같은 덜 심각한 에러를 가지고 작업을 할 예정. => 예외 (Exception)
		 * 
		 * 이러한 예외들이 발생했을 경우 , 에러를 "처리"하는 방법을 정의 하는것 => "예외 처리"
		 * 예외 처리를 해야하는 이유 : 예외 발생시 프로그램이 비정상적으로 종료되는 것을 막기 위함.
		 */
		
		A_UncheckedException au = new A_UncheckedException();
		//au.method3();
		
		B_CheckedException bc = new B_CheckedException();
		//bc.method1();
		
		int num = 1;
		int num2 = 2;
		
		if(num != num2) {
			// 에러 객체 생성 후, throw 키워드 사용
			// throw + 에러 객체
			throw new C_CustomException("사용자 정의 에러 발생 !!");
			
		}
		
		System.out.println("프로그램종료");

	}

}
