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
		// return String.join("", str.split(" "));
	}

	public String firstCap(String input) {

		// input.split("");

		char temp = input.toUpperCase().charAt(0);

		/*
		 * if (temp >= 97 && temp <= 122) { temp = (char) (temp - 32); }
		 */

		return String.valueOf(temp).concat(input.substring(1));

	}

	public int findChar(String input, char one) {
		// char[] arr = input.toCharArray();
		// for(char ch : arr) {if(ch == one) count++;}
		
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == one) {
				count++;
			}
		}

		return count;
	}
}
