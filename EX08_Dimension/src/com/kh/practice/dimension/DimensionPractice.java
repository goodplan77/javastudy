package com.kh.practice.dimension;

public class DimensionPractice {

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

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
						
			}
		}

	}

}
