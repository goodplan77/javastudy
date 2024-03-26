package com.kh.practice.dimension;

import java.util.Scanner;

public class DimensionPractice {

	Scanner sc = new Scanner(System.in);

	public void practice1() {
		String[][] array = new String[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				array[i][j] = "(" + i + ", " + j + ")";
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}

	}

	public void practice2() {
		int[][] array = new int[4][4];
		int count = 1;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				array[i][j] = count++;
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.printf("%d ", array[i][j]);
			}
			System.out.println();
		}
	}

	public void practice3() {
		int[][] array = new int[4][4];
		int count = 16;

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				array[i][j] = count--;
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.printf("%d ", array[i][j]);
			}
			System.out.println();
		}
	}

	public void practice4() {

		int[][] array = new int[4][4];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				array[i][j] = (int) (Math.random() * 10 + 1);
				array[i][3] += array[i][j];
				array[3][j] += array[i][j];
			}
		}

		for (int j = 0; j < 3; j++) {
			array[3][3] += (array[j][3] + array[3][j]);
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.printf("%d ", array[i][j]);
			}
			System.out.println();
		}

	}

	public void practice5() {

		while (true) {
			System.out.print("행 크기 : ");
			int row = sc.nextInt();
			System.out.print("열 크기 : ");
			int column = sc.nextInt();

			if ((row >= 1 && row <= 10) && (column >= 1 && column <= 10)) {
				char[][] input = new char[row][column];
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < column; j++) {
						input[i][j] = (char) (Math.random() * 26 + 65);
					}
				}

				for (int i = 0; i < row; i++) {
					for (int j = 0; j < column; j++) {
						System.out.printf("%c ", input[i][j]);
					}
					System.out.println();
				}

				break;

			} else {
				System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
				continue;
			}
		}
	}

	public void practice6() {
		String[][] strArr = new String[][] { { "이", "까", "왔", "앞", "힘" }, { "차", "지", "습", "으", "냅" },
				{ "원", "열", "니", "로", "시" }, { "배", "심", "다", "좀", "다" }, { "열", "히", "! ", "더", "!! " } };

		for (int i = 0; i < strArr.length; i++) {
			for (int j = 0; j < strArr.length; j++) {
				System.out.print(strArr[j][i] + " ");
			}
		}
	}

	public void practice7() {

		System.out.print("행의 크기 : ");
		int row = sc.nextInt();
		char[][] bb = new char[row][];
		char init = 'a';

		for (int i = 0; i < row; i++) {
			System.out.print(i + "행의 열 크기 : ");
			int input = sc.nextInt();
			bb[i]= new char[input];
			for (int j = 0; j < input; j++) {
				bb[i][j] = init++;
			}

		}

		for (int i = 0; i < bb.length; i++) {
			for (int j = 0; j < bb[i].length; j++) {
				System.out.printf("%c ", bb[i][j]);
			}
			System.out.println();
		}

	}

	public void practice8() {
		String[] students = { "강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하" };
		String[][] arrange1 = new String[3][2];
		String[][] arrange2 = new String[3][2];

		int count = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				arrange1[i][j] = students[count++];
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				arrange2[i][j] = students[count++];
			}
		}

		System.out.println("== 1분단 ==");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(arrange1[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("== 2분단 ==");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(arrange2[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void practice9() {
		String[] students = { "강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하" };
		String[][] arrange1 = new String[3][2];
		String[][] arrange2 = new String[3][2];

		int count = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				arrange1[i][j] = students[count++];
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				arrange2[i][j] = students[count++];
			}
		}

		System.out.println("== 1분단 ==");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(arrange1[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("== 2분단 ==");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(arrange2[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("============================");
		System.out.print("검색할 학생 이름을 입력하세요 : ");
		String input = sc.nextLine();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				if (input.equals(arrange1[i][j])) {
					System.out.println(p9_position_method(input, 0, i, j));
					break;

				} else if (input.equals(arrange2[i][j])) {
					System.out.println(p9_position_method(input, 1, i, j));
					break;
				}
			}
		}
	}

	private String p9_position_method(String input, int d, int l, int s) {
		int division = 0;
		int line = 0;
		String side = "";

		switch (d) {
		case 0:
			division = 1;
			break;
		case 1:
			division = 2;
			break;
		}

		switch (l) {
		case 0:
			line = 1;
			break;
		case 1:
			line = 2;
			break;
		case 2:
			line = 3;
			break;
		}

		switch (s) {
		case 0:
			side = "왼";
			break;
		case 1:
			side = "오른";
			break;
		}

		return "검색하신 " + input + " 학생은 " + division + "분단 " + line + "번째 줄 " + side + "쪽에 있습니다.";
	}

	public void practice10() {
		String[][] array = new String[6][6];

		for (int i = 0; i < 6; i++) {
			if (i == 0) {
				array[i][0] = " ";
				for (int j = 1; j < 6; j++) {
					array[i][j] = Integer.toString(j - 1);
				}
			} else {
				array[i][0] = Integer.toString(i - 1);
				for (int j = 1; j < 6; j++) {
					array[i][j] = " ";
				}
			}
		}

		System.out.print("행 인덱스 입력 : ");
		int row = sc.nextInt();

		System.out.print("열 인덱스 입력 : ");
		int column = sc.nextInt();

		array[row + 1][column + 1] = "X";

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.printf("%s ", array[i][j]);
			}
			System.out.println();
		}
	}

	public void practice11() {

		String[][] array = new String[6][6];

		for (int i = 0; i < 6; i++) {
			if (i == 0) {
				array[i][0] = " ";
				for (int j = 1; j < 6; j++) {
					array[i][j] = Integer.toString(j - 1);
				}
			} else {
				array[i][0] = Integer.toString(i - 1);
				for (int j = 1; j < 6; j++) {
					array[i][j] = " ";
				}
			}
		}

		while (true) {
			System.out.print("행 인덱스 입력 : ");
			int row = sc.nextInt();

			if (row == 99) {
				System.out.println("프로그램 종료");
				break;
			}

			System.out.print("열 인덱스 입력 : ");
			int column = sc.nextInt();

			array[row + 1][column + 1] = "X";

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					System.out.printf("%s ", array[i][j]);
				}
				System.out.println();
			}
		}

	}

}
