package com.kh.practice.charCheck.controller;

import com.kh.practice.charCheck.exception.CharCheckException;

public class CharacterController {

	public CharacterController() {

	}

	public int countAlpha(String s) throws CharCheckException{
		char[] temp = s.toCharArray();
		int count = 0;
		for(char ch : temp) {
			if(ch==' ') {
				throw new CharCheckException("체크할 문자열 안에 공백이 포함되어 있습니다.");
			} else {
				if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
				{
					count++;
				}
			}
		}
		return count;
	}

}
