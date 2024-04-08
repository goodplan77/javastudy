package com.kh.practice.list.music.view;

import java.util.Scanner;

import com.kh.practice.list.music.controller.MusicController;
import com.kh.practice.list.music.model.vo.Music;

public class MusicView {

	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();

	public void mainMenu() {

		while (true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 정보 수정");
			System.out.println("7. 곡명 오름차순 정렬");
			System.out.println("8. 가수명 내림차순 정렬 ");
			System.out.println("9. 종료");
			System.out.println();
			System.out.print("메뉴 번호 입력 : ");
			int menuSelect = Integer.parseInt(sc.nextLine());

			switch (menuSelect) {
			case 1:
				addList();
				break;
			case 2:
				addAtZero();
				break;
			case 3:
				printAll();
				break;
			case 4:
				searchMusic();
				break;
			case 5:
				removeMusic();
				break;
			case 6:
				setMusic();
				break;
			case 7:
				ascTitle();
				break;
			case 8:
				descSinger();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("에러");
				break;
			}
		}
	}

	public void addList() {
		System.out.println("****** 마지막 위치에 곡 추가 ******");

		System.out.print("곡 명 : ");
		String inputTitle = sc.nextLine();

		System.out.print("가수 명 : ");
		String inputSinger = sc.nextLine();

		if (mc.addList(new Music(inputTitle, inputSinger)) > 0) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}

	public void addAtZero() {
		System.out.println("****** 첫 위치에 곡 추가 ******");

		System.out.print("곡 명 : ");
		String inputTitle = sc.nextLine();

		System.out.print("가수 명 : ");
		String inputSinger = sc.nextLine();

		if (mc.addAtZero(new Music(inputTitle, inputSinger)) > 0) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}

	public void printAll() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		System.out.println(mc.printAll());
	}

	public void searchMusic() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.print("검색할 곡 명 : ");
		String searchTitle = sc.nextLine();
		Music temp = mc.searchMusic(searchTitle);
		System.out.println(temp);
	}

	public void removeMusic() {
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.print("삭제할 곡 명 : ");
		String searchTitle = sc.nextLine();
		Music temp = mc.removeMusic(searchTitle);
		if (temp != null) {
			System.out.println(temp.getSinger() + " - " + temp.getTitle() + "을 삭제 했습니다.");
		} else {
			System.out.println("검색한 곡이 없습니다");
		}

	}

	public void setMusic() {
		System.out.println("****** 특정 곡 정보 수정 ******");
		System.out.print("검색할 곡 명 : ");
		String searchTitle = sc.nextLine();
		
		System.out.print("수정할 곡 명 : ");
		String setTitle = sc.nextLine();
		
		System.out.print("수정할 가수 명 : ");
		String setSinger = sc.nextLine();
		
		Music temp = mc.setMusic(searchTitle , new Music(setTitle,setSinger));
		
		if (temp != null) {
			System.out.println(temp.getSinger() + " - " + temp.getTitle() + "가 값이 변경되었습니다.");
		} else {
			System.out.println("검색한 곡이 없습니다");
		}
	}

	public void ascTitle() {
		if(mc.ascTitle() > 0) {
			System.out.println("정렬 성공");
		} else {
			System.out.println("정렬 실패");
		}
	}

	public void descSinger() {
		if(mc.descSinger() > 0) {
			System.out.println("정렬 성공");
		} else {
			System.out.println("정렬 실패");
		}
	}

}
