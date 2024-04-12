package com.kh.practice.map.view;

import java.util.Map.Entry;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.kh.practice.map.controller.MemberController;
import com.kh.practice.map.model.vo.Member;

public class MemberMenu {

	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();

	public void mainMenu() {
		System.out.println("========== KH 사이트 ==========");

		while (true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인 ");
			System.out.println("3. 같은 이름 회원 찾기");
			System.out.println("9. 종료");

			System.out.println();
			System.out.print("메뉴 번호 선택 : ");
			int menuSelect = Integer.parseInt(sc.nextLine());

			switch (menuSelect) {
			case 1:
				joinMembership();
				break;
			case 2:
				logIn();
				break;
			case 3:
				sameName();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
				break;
			}
		}
	}

	public void memberMenu() {

		while (true) {
			System.out.println("******* 회원 메뉴 *******");
			System.out.println("1. 비밀번호 바꾸기");
			System.out.println("2. 이름 바꾸기");
			System.out.println("3. 로그아웃 ");

			System.out.println();
			System.out.print("메뉴 번호 선택 : ");
			int menuSelect = Integer.parseInt(sc.nextLine());

			switch (menuSelect) {
			case 1:
				changePassword();
				break;
			case 2:
				changeName();
				break;
			case 3:
				System.out.println("로그아웃 되었습니다");
				return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
				break;
			}
		}

	}

	public void joinMembership() {

		while (true) {
			System.out.print("아이디 : ");
			String inputId = sc.nextLine();

			System.out.print("비밀번호 : ");
			String inputPassword = sc.nextLine();

			System.out.print("이름 : ");
			String inputName = sc.nextLine();

			Member temp = new Member(inputPassword, inputName);

			boolean result = mc.joinMembership(inputId, temp);

			if (result) {
				System.out.println("성공적으로 회원가입 완료하였습니다");
				break;
			} else {
				System.out.println("중복된 아이디입니다. 다시 입력해주세요");
			}
		}

	}

	public void logIn() {

		while (true) {
			System.out.print("아이디 : ");
			String inputId = sc.nextLine();

			System.out.print("비밀번호 : ");
			String inputPassword = sc.nextLine();

			String result = mc.logIn(inputId, inputPassword);
			if (result != null) {
				System.out.println(result + "님, 환영합니다.");
				memberMenu();
				break;
			} else {
				System.out.println("틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.");
			}
		}

	}

	public void changePassword() {
		System.out.print("아이디 : ");
		String inputId = sc.nextLine();

		System.out.print("현재 비밀번호 : ");
		String inputOldPassword = sc.nextLine();

		System.out.print("새로운 비밀번호 : ");
		String inputNewPassword = sc.nextLine();

		if (mc.changePassword(inputId, inputOldPassword, inputNewPassword)) {
			System.out.println("비밀번호 변경에 성공했습니다.");
		} else {
			System.out.println("비밀번호 변경에 실패했습니다. 다시 입력해주세요");
		}
	}

	public void changeName() {

		while (true) {
			System.out.print("아이디 : ");
			String inputId = sc.nextLine();

			System.out.print("비밀번호 : ");
			String inputPassword = sc.nextLine();

			String result = mc.logIn(inputId, inputPassword);

			if (result != null) {
				System.out.println("현재 설정된 이름 : " + result);
				System.out.print("변경할 이름 : ");
				String inputNewName = sc.nextLine();
				mc.changeName(inputId, inputNewName);
				System.out.println("이름 변경에 성공했습니다.");
				break;
			} else {
				System.out.println("이름 변경에 실패했습니다. 다시 입력해주세요");
			}
		}

	}

	public void sameName() {
		System.out.print("검색할 이름 : ");
		String searchName = sc.nextLine();

		TreeMap<String, String> temp = mc.sameName(searchName);
		Set<Entry<String, String>> entrySet = temp.entrySet();
		Iterator<Entry<String, String>> itEntry = entrySet.iterator();
		while (itEntry.hasNext()) {
			Entry<String, String> entry = itEntry.next();
			System.out.println(entry.getValue() + "-" + entry.getKey());
		}
	}

}
