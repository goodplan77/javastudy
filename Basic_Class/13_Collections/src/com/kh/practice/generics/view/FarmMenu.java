package com.kh.practice.generics.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.kh.practice.generics.controller.FarmController;
import com.kh.practice.generics.model.vo.Farm;
import com.kh.practice.generics.model.vo.Fruit;
import com.kh.practice.generics.model.vo.Nut;
import com.kh.practice.generics.model.vo.Vegetable;

public class FarmMenu {

	private Scanner sc = new Scanner(System.in);
	private FarmController fc = new FarmController();

	public void mainMenu() {
		System.out.println("========== KH 마트 ==========");

		while (true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 직원메뉴");
			System.out.println("2. 손님 메뉴");
			System.out.println("9. 종료 ");

			System.out.print("\n" + "메뉴 번호 선택 : ");
			int menuSelect = Integer.parseInt(sc.nextLine());

			switch (menuSelect) {
			case 1:
				adminMenu();
				break;
			case 2:
				customerMenu();
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

	public void adminMenu() {
		while (true) {
			System.out.println("******* 직원 메뉴 *******");
			System.out.println("1. 새 농산물 추가");
			System.out.println("2. 종류 삭제");
			System.out.println("3. 수량 수정 ");
			System.out.println("4. 농산물 목록");
			System.out.println("9. 종료 ");

			System.out.print("\n" + "메뉴 번호 선택 : ");
			int menuSelect = Integer.parseInt(sc.nextLine());

			switch (menuSelect) {
			case 1:
				addNewKind();
				break;
			case 2:
				removeKind();
				break;
			case 3:
				changeAmount();
				break;
			case 4:
				printFarm();
				break;
			case 9:
				return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
				break;
			}
		}

	}

	public void customerMenu() {
		System.out.println("현재 KH마트 농산물 수량");
		printFarm();

		while (true) {
			System.out.println("******* 고객 메뉴 *******");
			System.out.println("1. 농산물 사기");
			System.out.println("2. 농산물 빼기");
			System.out.println("3. 구입한 농산물 보기");
			System.out.println("9. 종료 ");

			System.out.print("\n" + "메뉴 번호 선택 : ");
			int menuSelect = Integer.parseInt(sc.nextLine());

			switch (menuSelect) {
			case 1:
				buyFarm();
				break;
			case 2:
				removeFarm();
				break;
			case 3:
				printBuyFarm();
				break;
			case 9:
				return;
			default:
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
				break;
			}
		}
	}

	public void addNewKind() {

		Farm temp = null;
		while (true) {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			int select = Integer.parseInt(sc.nextLine());

			switch (select) {
			case 1:
				temp = new Fruit("과일", null);
				break;
			case 2:
				temp = new Vegetable("채소", null);
				break;
			case 3:
				temp = new Nut("견과", null);
				break;
			}

			if (temp == null) {
				System.out.println("올바른 값을 입력하세요.");
				continue;
			} else {
				break;
			}
		}

		System.out.print("이름 : ");
		String inputName = sc.nextLine();

		if (temp instanceof Fruit) {
			((Fruit) temp).setName(inputName);
		} else if (temp instanceof Vegetable) {
			((Vegetable) temp).setName(inputName);
		} else if (temp instanceof Nut) {
			((Nut) temp).setName(inputName);
		}

		System.out.print("수량 : ");
		int inputCount = Integer.parseInt(sc.nextLine());

		if (fc.addNewKind(temp, inputCount)) {
			System.out.println("새 농산물이 추가되었습니다");
		} else {
			System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요");
		}
	}

	public void removeKind() {

		Farm temp = null;
		while (true) {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			int select = Integer.parseInt(sc.nextLine());

			switch (select) {
			case 1:
				temp = new Fruit("과일", null);
				break;
			case 2:
				temp = new Vegetable("채소", null);
				break;
			case 3:
				temp = new Nut("견과", null);
				break;
			}

			if (temp == null) {
				System.out.println("올바른 값을 입력하세요.");
				continue;
			} else {
				break;
			}
		}

		System.out.print("이름 : ");
		String inputName = sc.nextLine();

		if (temp instanceof Fruit) {
			((Fruit) temp).setName(inputName);
		} else if (temp instanceof Vegetable) {
			((Vegetable) temp).setName(inputName);
		} else if (temp instanceof Nut) {
			((Nut) temp).setName(inputName);
		}

		if (fc.removeKind(temp)) {
			System.out.println("새 농산물이 추가되었습니다");
		} else {
			System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요");
		}

	}

	public void changeAmount() {
		Farm temp = null;
		while (true) {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			int select = Integer.parseInt(sc.nextLine());

			switch (select) {
			case 1:
				temp = new Fruit("과일", null);
				break;
			case 2:
				temp = new Vegetable("채소", null);
				break;
			case 3:
				temp = new Nut("견과", null);
				break;
			}

			if (temp == null) {
				System.out.println("올바른 값을 입력하세요.");
				continue;
			} else {
				break;
			}
		}

		System.out.print("이름 : ");
		String inputName = sc.nextLine();

		if (temp instanceof Fruit) {
			((Fruit) temp).setName(inputName);
		} else if (temp instanceof Vegetable) {
			((Vegetable) temp).setName(inputName);
		} else if (temp instanceof Nut) {
			((Nut) temp).setName(inputName);
		}

		System.out.print("수량 : ");
		int inputCount = Integer.parseInt(sc.nextLine());

		if (fc.changeAmount(temp, inputCount)) {
			System.out.println("새 농산물이 추가되었습니다");
		} else {
			System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요");
		}
	}

	public void printFarm() {
		Set<Farm> set = fc.printFarm().keySet();
		for (Farm s : set) {
			String kind = s.getKind();
			String name = "";
			if (s instanceof Fruit) {
				name = ((Fruit) s).getName();
			} else if (s instanceof Vegetable) {
				name = ((Vegetable) s).getName();
			} else if (s instanceof Nut) {
				name = ((Nut) s).getName();
			}
			int amount = fc.printFarm().get(s);

			System.out.println(kind + " : " + name + "(" + amount + "개)");
		}
	}

	public void buyFarm() {

		Farm temp = null;
		while (true) {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			int select = Integer.parseInt(sc.nextLine());

			switch (select) {
			case 1:
				temp = new Fruit("과일", null);
				break;
			case 2:
				temp = new Vegetable("채소", null);
				break;
			case 3:
				temp = new Nut("견과", null);
				break;
			}

			if (temp == null) {
				System.out.println("올바른 값을 입력하세요.");
				continue;
			} else {
				break;
			}
		}

		System.out.print("이름 : ");
		String inputName = sc.nextLine();

		if (temp instanceof Fruit) {
			((Fruit) temp).setName(inputName);
		} else if (temp instanceof Vegetable) {
			((Vegetable) temp).setName(inputName);
		} else if (temp instanceof Nut) {
			((Nut) temp).setName(inputName);
		}

		if (fc.buyFarm(temp)) {
			System.out.println("구매에 성공하였습니다");
		} else {
			System.out.println("마트에 없는 물건이거나 수량이 없습니다. 다시 입력해주세요");
		}
	}

	public void removeFarm() {
		Farm temp = null;
		while (true) {
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			int select = Integer.parseInt(sc.nextLine());

			switch (select) {
			case 1:
				temp = new Fruit("과일", null);
				break;
			case 2:
				temp = new Vegetable("채소", null);
				break;
			case 3:
				temp = new Nut("견과", null);
				break;
			}

			if (temp == null) {
				System.out.println("올바른 값을 입력하세요.");
				continue;
			} else {
				break;
			}
		}

		System.out.print("이름 : ");
		String inputName = sc.nextLine();

		if (temp instanceof Fruit) {
			((Fruit) temp).setName(inputName);
		} else if (temp instanceof Vegetable) {
			((Vegetable) temp).setName(inputName);
		} else if (temp instanceof Nut) {
			((Nut) temp).setName(inputName);
		}

		if (fc.removeFarm(temp)) {
			System.out.println("구매 취소에 성공하였습니다");
		} else {
			System.out.println("구매매 목록에 존재하지 않습니다. 다시 입력해주세요");
		}
	}

	public void printBuyFarm() {
		ArrayList<Farm> list = fc.printBuyFarm();
		Iterator<Farm> iter = list.iterator();

		while (iter.hasNext()) {
			Farm temp = iter.next();
			String kind = temp.getKind();
			String name = "";
			if (temp instanceof Fruit) {
				name = ((Fruit) temp).getName();
			} else if (temp instanceof Vegetable) {
				name = ((Vegetable) temp).getName();
			} else if (temp instanceof Nut) {
				name = ((Nut) temp).getName();
			}

			System.out.println(kind + " : " + name);
		}
	}

}
