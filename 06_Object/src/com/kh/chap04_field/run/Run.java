package com.kh.chap04_field.run;

import com.kh.chap04_field.medel.vo.FieldTest1;
import com.kh.chap04_field.medel.vo.FieldTest2;
import com.kh.chap04_field.medel.vo.FieldTest3;

public class Run {

	public static void main(String[] args) {
		
		FieldTest1 ft1 = new FieldTest1();
		ft1.test(123);
	
		FieldTest2 ft2 = new FieldTest2();
		System.out.println(ft2.pub);
//		System.out.println(ft2.pro);	//같은 패키지에서만, 다른 패키지라면 상속을 통해 접근 
//		System.out.println(ft2.df);		//같은 패키지에서만 접근 가능
//		System.out.println(ft2.pri);	//ft2클래스에서만 접근 가능
		
		
//		FieldTest3 ft3 = new FieldTest3();
		
		System.out.println(FieldTest3.sta);	//static한 접근 방식.
											//클래스명.stasic변수명
		FieldTest3.sta = "FieldTest33.sta";
//		FieldTest3.NUM = 1;				//final 키워드가 붙은 경우 수정 불가
		System.out.println(FieldTest3.sta);
		
		//static 호출방식
		FieldTest3.test();
		
		
		
	}

}
