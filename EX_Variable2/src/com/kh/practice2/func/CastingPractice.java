package com.kh.practice2.func;

import java.util.Scanner;

public class CastingPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public void subject() {
		
		System.out.print("국어 : ");
		double KoreanScore = sc.nextDouble();
		
		System.out.print("영어 : ");
		double EnglishScore = sc.nextDouble();
		
		System.out.print("수학 : ");
		double MathScore = sc.nextDouble();
		
		int total = (int)KoreanScore + (int)EnglishScore + (int)MathScore;
		int average = total / 3 ;
		
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + average);
		
		
	}

}
