package com.kh.chap02_string.controller;

public class A_StringPoolTest {
	//String은 불변클래스(담긴 값이 변하지 않는 클래스)
	
	// 1. 생성자를 통한 String객체 생성
	public void method1() {
		
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		boolean result = (str1 == str2); // false
		
		System.out.println(str1.toString());
		System.out.println(str2.toString());
		
		//String에서 문자열 값끼리만 비교할수 있도록 equals메소드를 override함
		result = str1.equals(str2); // true
		
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		/*
		 * 기존 hashcode() 의 경우 16진수 메모리 주소값을 10진수 형태로 변환해준 값을 반환 했다면 ,
		 * String 클래스의 hashcode() 메소드의 경우 주소값 기반이 아닌,
		 * 저장된 "문자열" 기반으로 해시코드값을 만들어서 반환하도록 재정의 하였음.
		 */
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
	}
	
	// 2. 문자열 리터럴로 생성
	public void method2() {
		String str1 = "hello"; // 상수풀에 hello문자열 저장
		String str2 = "hello"; // 상수풀에 hello문자열 저장
		// hello라는 문자열로 hashcode() 함수 호출시 반환되는 정수값에 문자열이 할당되어 있으므로 , 저장된 값을 꺼내옴
		
		/*
		 * String[] arr = String[99999999999];
		 * arr[9916233] == null ? null일시 값 대입 : 아닐시 저장된 데이터 가져다 씀
		 * arr[9916233]  = "hello";
		 * 
		 * JVM이 클래스안의 정보를 읽어 들이면서 , 문자열 리터럴을 만나면
		 * 문자열 리터럴 주소값을 얻어와서 , 주소값 위치에 값이 대입된적 있는지 확인 후(intern())
		 * 대입된 적이 있다면 , 주소값을 그대로 반환.
		 * 없다면 , 상수 풀의 주소값에 문자열 등록후 주소값을 반환함 => 동일한 문자열은 동일한 공간사용
		 * 
		 * 따라서 동일한 문자열 리터럴을 제시시 새롭게 저장공간을 할당하지 않고 , 이미 저장된
		 * 주소값을 공유해서 사용하므로 , 저장공간을 효율적으로 사용 가능.
		 */
		
		boolean result = (str1==str2);
		
		System.out.println(result);
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		
	}
	
	// 불변클래스
	// 문자열을 값을 수정하는 순간 기존의 값이 담겨있던 저장공간에서 수정되지 않음.
	public void method3() {
		
		String str = "hello";
		System.out.println(System.identityHashCode(str));
		
		str += "goodbye"; //hellogoodbye
		System.out.println(System.identityHashCode(str));
		
		str += "abc"; //hellogoodbyeabc
		System.out.println(System.identityHashCode(str));
		
		/*
		 * 자바에서 가장 많이 사용되는 객체가 String
		 * String이 메모리영역에서 할당된 후 사라지지 않는다면 메모리 부족 이슈가 발생
		 * 
		 * 기존의 상수풀의 연결이 끊긴 문자열들은 가비지 컬렉터(GC) 가 알아서 정리해주게끔 변경.
		 * 불변클래스라고 해서 값 수정이 안되는 것이 아니라 , 
		 * 기존의 저장 공간에서 수정이 안된다는 것.
		 * 값을 변경할때마다 매번 새로운 주소값을 참조하게 된다.
		 */
		
		// 메모리 영역 효율성을 위해 String의 경우 new를 이용한 관리 보다 리터럴 문자열을 이용한 관리를 추천함
		// 문자열 연산이 자주 이루어 질 경우 , 기존 String을 이용한 연산은 추천하지 않음?
	}

}
