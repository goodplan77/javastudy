package com.kh.practice.score.view;

import java.util.Scanner;
import com.kh.practice.score.controller.ScoreController;

public class ScoreMenu {

	private Scanner sc = new Scanner(System.in);
	private ScoreController scr = new ScoreController();

	public void mainMenu() {
		while (true) {
			System.out.println("1. 성적 저장");
			System.out.println("2. 성적 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1:
				saveScore();
				break;
			case 2:
				readScore();
				break;
			case 9:
				return;
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				break;
			}
		}

	}

	public void saveScore() {
		int num = 1;
		while(true) {
			System.out.println(num+"번째 학생 정보 기록");
			System.out.print("이름 : ");
			String name = sc.nextLine();
			
			System.out.print("국어 점수 :");
			int korScore = sc.nextInt();
			
			System.out.print("영어 점수 :");
			int engScore = sc.nextInt();
		
			System.out.print("수학 점수 :");
			int mathScore = sc.nextInt();
			
			int sum = korScore + engScore + mathScore;
			double avg = (double)sum / 3;
			
			scr.saveScore(name, korScore, engScore, mathScore, sum, avg);
			
			sc.nextLine();
			
			System.out.print("그만 입력하시려면 N 또는 n 입력, 계속 하시려면 아무 키나 입력하세요 :");
			char select = sc.nextLine().toLowerCase().charAt(0);
			
			if(select == 'n') {
				break;
			} else {
				num++;
			}
		}
	}

	public void readScore() {
		int count = 0;
		int sumAll = 0;
		double avgAll = 0;
		
	}

}
