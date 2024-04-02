package com.kh.practice.chap02_abstractNInterface.controller;

import com.kh.practice.chap02_abstractNInterface.model.vo.GalaxyNote9;
import com.kh.practice.chap02_abstractNInterface.model.vo.Phone;
import com.kh.practice.chap02_abstractNInterface.model.vo.SmartPhone;
import com.kh.practice.chap02_abstractNInterface.model.vo.V40;

public class PhoneController {

	private String[] result = new String[2];

	public String[] method() {
		Phone[] phone = new Phone[2];
		phone[0] = new GalaxyNote9();
		phone[1] = new V40();

		for (int i = 0; i < 2; i++) {
			
			// phone[i] 가 실제 참조하고 있는 클래스가 GalaxyNote9 이라면?
			// 1)
			if (phone[i] instanceof GalaxyNote9) {
				result[i] = ((GalaxyNote9) phone[i]).printInformation();
			} else if (phone[i] instanceof V40) {
				result[i] = ((V40) phone[i]).printInformation();
			}
			
			// 2) phone[i] => Phone(최상위 클래스) => downCasting => SmartPhone.printInformation();
			// => 동적바인딩 => GalaxyNote9 , V40에 적용된 오버라이드 된 메서드 실행
			// result[i] = ((SmartPhone)phone[i]).printInformation();
			
			
		}

		return result;
	}

}
