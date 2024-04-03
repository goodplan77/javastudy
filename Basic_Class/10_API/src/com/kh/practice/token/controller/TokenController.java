package com.kh.practice.token.controller;

import java.util.StringTokenizer;

public class TokenController {

	public TokenController() {

	}

	public String afterToken(String str) {
		StringTokenizer st = new StringTokenizer(str);
		StringBuilder sb = new StringBuilder("");
		while (st.hasMoreTokens()) {
			sb.append(st.nextToken());
		}
		return sb.toString();
		//return String.join("", str.split(" "));
	}

	public String firstCap(String input) {
		char temp1 = input.charAt(0);
		String temp2 = input.substring(1);
		if (temp1 >= 97 && temp1 <= 122) {
			temp1 = (char) (temp1 - 32);
		}

		return temp1 + temp2;

	}

	public int findChar(String input, char one) {
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == one) {
				count++;
			}
		}

		return count;
	}
}
