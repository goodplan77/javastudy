package com.kh.hw.member.view;

import java.util.Scanner;

import com.kh.hw.member.controller.MemberController;
import com.kh.hw.member.model.vo.Member;

public class MemberMenu {

	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();

	public MemberMenu() {

	}

	public void mainMenu() {

		while (true) {
			System.out.println("최대 등록 가능한 회원 수는 10명입니다.");
			System.out.printf("현재 등록된 회원 수는 %d명입니다.\n", mc.existMemberNum());

			if (mc.existMemberNum() != 10) {
				System.out.println("1. 새 회원 등록");
			} else {
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
			}

			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 모두 출력");
			System.out.println("9. 끝내기");

			System.out.print("메뉴 번호 : ");
			int menuSelect = sc.nextInt();
			sc.nextLine();

			switch (menuSelect) {
			case 2:
				searchMember();
				break;
			case 3:
				updateMember();
				break;
			case 4:
				deleteMember();
				break;
			case 5:
				printAll();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			case 1: {
				if (mc.existMemberNum() != 10) {
					insertMember();
					break;
				}
			}
			default:
				System.out.println("다시 입력해주세요.");
			}

			System.out.println();
		}
	}

	public void insertMember() {
		System.out.println("새 회원을 등록합니다.");
		String inputId;
		while (true) {
			System.out.print("아이디 : ");
			inputId = sc.nextLine();
			if (mc.checkId(inputId)) {
				System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
				continue;
			} else {
				break;
			}
		}

		System.out.print("이름 : ");
		String inputName = sc.nextLine();

		System.out.print("비밀번호 : ");
		String inputPassword = sc.nextLine();

		System.out.print("이메일 : ");
		String inputEmail = sc.nextLine();

		String inputGender = "";

		while (true) {

			System.out.print("성별(M/F) : ");
			inputGender = sc.nextLine();
			if (inputGender.equals("M") || inputGender.equals("m") || inputGender.equals("F")
					|| inputGender.equals("f")) {
				break;
			} else {
				System.out.println("성별을 다시 입력하세요.");
				continue;
			}
		}

		System.out.print("나이 : ");
		int inputAge = sc.nextInt();
		sc.nextLine();

		mc.insertMember(inputId, inputName, inputPassword, inputEmail, inputGender, inputAge);
	}

	public void searchMember() {
		System.out.println("1. 아이디로 검색하기");
		System.out.println("2. 이름으로 검색하기");
		System.out.println("3. 이메일로 검색하기");
		System.out.println("9. 메인으로 돌아가기");

		System.out.print("메뉴 번호 : ");
		int menuSelect = sc.nextInt();
		sc.nextLine();

		switch (menuSelect) {
		case 1:
			searchId();
			break;
		case 2:
			searchName();
			break;
		case 3:
			searchEmail();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다");
			break;
		}

		System.out.println();

	}

	public void searchId() {
		System.out.print("검색할 아이디 : ");
		String inputId = sc.nextLine();

		if (mc.searchId(inputId) != null) {
			System.out.println(mc.searchId(inputId));
		} else {
			System.out.println("검색 결과가 없습니다.");
		}
	}

	public void searchName() {
		System.out.print("검색할 이름 : ");
		String inputName = sc.nextLine();

		for (Member m : mc.searchName(inputName)) {
			if (m == null) {
				System.out.println("검색 결과가 없습니다.");
				break;
			} else {
				System.out.println(m.inform());
			}
		}

	}

	public void searchEmail() {
		System.out.print("검색할 이메일 : ");
		String inputEmail = sc.nextLine();

		for (Member m : mc.searchName(inputEmail)) {
			if (m == null) {
				System.out.println("검색 결과가 없습니다.");
				break;
			} else {
				System.out.println(m.inform());
			}
		}
	}

	public void updateMember() {
		System.out.println("1. 비밀번호 수정하기");
		System.out.println("2. 이름 수정하기");
		System.out.println("3. 이메일 수정하기");
		System.out.println("9. 메인으로 돌아가기");

		System.out.print("메뉴 번호 : ");
		int menuSelect = sc.nextInt();
		sc.nextLine();

		switch (menuSelect) {
		case 1:
			updatePassword();
			break;
		case 2:
			updateName();
			break;
		case 3:
			updateEmail();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다");
			break;
		}

		System.out.println();
	}

	public void updatePassword() {
		System.out.print("수정할 회원의 아이디 : ");
		String inputId = sc.nextLine();

		System.out.print("수정할 비밀번호 : ");
		String inputPassword = sc.nextLine();

		if (mc.updatePassword(inputId, inputPassword)) {
			System.out.println("수정이 성공적으로 되었습니다.");
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}

	public void updateName() {
		System.out.print("수정할 회원의 아이디 : ");
		String inputId = sc.nextLine();

		System.out.print("수정할 이름 : ");
		String inputName = sc.nextLine();

		if (mc.updateName(inputId, inputName)) {
			System.out.println("수정이 성공적으로 되었습니다.");
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}

	public void updateEmail() {
		System.out.print("수정할 회원의 아이디 : ");
		String inputId = sc.nextLine();

		System.out.print("수정할 이메일 : ");
		String inputEmail = sc.nextLine();

		if (mc.updateEmail(inputId, inputEmail)) {
			System.out.println("수정이 성공적으로 되었습니다.");
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}

	public void deleteMember() {
		System.out.println("1. 특정 회원 삭제하기");
		System.out.println("2. 모든 회원 삭제하기 ");
		System.out.println("9. 메인으로 돌아가기");

		System.out.print("메뉴 번호 : ");
		int menuSelect = sc.nextInt();
		sc.nextLine();

		switch (menuSelect) {
		case 1:
			deleteOne();
			break;
		case 2:
			deleteAll();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다");
			break;
		}

		System.out.println();
	}

	public void deleteOne() {
		System.out.print("삭제할 회원의 아이디 : ");
		String inputId = sc.nextLine();

		System.out.print("정말 삭제하시겠습니까?(y/n) : ");
		char confirm = sc.nextLine().charAt(0);

		if (confirm == 'y' || confirm == 'Y') {
			if (mc.delete(inputId)) {
				System.out.println("성공적으로 삭제하였습니다.");
			} else {
				System.out.println("존재하지 않는 아이디입니다.");
			}
		}
	}

	public void deleteAll() {

		System.out.print("정말 삭제하시겠습니까?(y/n) : ");
		char confirm = sc.nextLine().charAt(0);

		if (confirm == 'y' || confirm == 'Y') {
			mc.delete();
			System.out.println("성공적으로 삭제하였습니다.");
		}
	}

	public void printAll() {
		if (mc.existMemberNum() == 0) {
			System.out.println("저장된 회원이 없습니다.");
			return;
		}

		/*
		 * for(int i = 0 ; i<existMemberNum() ; i++) {
		 * System.out.println(m[i].inform()); }
		 */

		for (Member temp : mc.printAll()) {
			if (temp != null) {
				System.out.println(temp.inform());
			}
		}
	}
}
