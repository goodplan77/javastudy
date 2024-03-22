package com.kh.practice.comp.func;

import java.util.Scanner;

public class RockPaperScissors {

	public void rps() {

		Scanner sc = new Scanner(System.in);

		System.out.print("당신의 이름을 입력해주세요 : ");
		String name = sc.nextLine();

		String rpsSelect;

		int winScore = 0;
		int loseScore = 0;
		int drawScore = 0;
		int count = 0;

		while (true) {

			System.out.print("가위바위보 : ");
			rpsSelect = sc.nextLine();

			if (rpsSelect.equals("exit")) {
				System.out.printf("%d전 %d승 %d무 %d패\n", count, winScore, drawScore, loseScore);
				break;
			} else if (!(rpsSelect.equals("가위")) && !(rpsSelect.equals("바위")) && !(rpsSelect.equals("보"))) {
				System.out.println("잘못 입력하였습니다.");
				continue;
			}

			String rpsCom;

			int random = (int) (Math.random() * 3);

			if (random == 0) {
				rpsCom = "가위";

			} else if (random == 1) {
				rpsCom = "바위";

			} else if (random == 2) {
				rpsCom = "보";
			} else {
				rpsCom = "ERROR";
			}

			System.out.printf("컴퓨터 : %s\n", rpsCom);
			System.out.printf("%s : %s\n", name, rpsSelect);

			int resultCheck = 0; // 사람이 이겼다 1 , 비겼다 0 , 사람이 졌다 -1

			if (rpsCom.equals("가위")) {
				if (rpsSelect.equals("가위"))
					resultCheck = 0;
				else if (rpsSelect.equals("바위"))
					resultCheck = 1;
				else if (rpsSelect.equals("보"))
					resultCheck = -1;
				else
					System.out.println("ERROR");
			} else if (rpsCom.equals("바위")) {
				if (rpsSelect.equals("가위"))
					resultCheck = -1;
				else if (rpsSelect.equals("바위"))
					resultCheck = 0;
				else if (rpsSelect.equals("보"))
					resultCheck = 1;
				else
					System.out.println("ERROR");

			} else if (rpsCom.equals("보")) {
				if (rpsSelect.equals("가위"))
					resultCheck = 1;
				else if (rpsSelect.equals("바위"))
					resultCheck = -1;
				else if (rpsSelect.equals("보"))
					resultCheck = 0;
				else
					System.out.println("ERROR");

			} else {
				System.out.println("ERROR");
			}

			switch (resultCheck) {
			case 1: {
				winScore++;
				System.out.println("이겼습니다 !");
				count++;
				break;
			}
			case 0: {
				drawScore++;
				System.out.println("비겼습니다.");
				count++;
				break;
			}
			case -1: {
				loseScore++;
				System.out.println("졌습니다 ㅠㅠ");
				count++;
				break;
			}
			}

			System.out.println();

		}
	}

}
