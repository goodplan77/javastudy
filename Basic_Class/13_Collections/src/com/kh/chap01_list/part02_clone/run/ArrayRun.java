package com.kh.chap01_list.part02_clone.run;

import java.util.Arrays;

import com.kh.chap01_list.part01_arrayList.model.vo.Music;

public class ArrayRun {

	private static final int DEFAULT_CAPACITY = 10; // 기본 생성자 호출시 사용되는 객체의 크기값
	Music[] mArr;
	private int size;

	public ArrayRun() {
		mArr = new Music[DEFAULT_CAPACITY]; // 기본 생성자 호출시 길이 10짜리 Music 객체 배열 생성
	}

	public ArrayRun(int initialCapacity) {
		mArr = new Music[initialCapacity];
	}

	public static void main(String[] args) {
		// 기본 생성자 호출
		ArrayRun ar = new ArrayRun();

		// 매개 변수 있는 생성자(길이 5짜리 배열)
		ArrayRun ar2 = new ArrayRun(3);

		// System.out.println(ar);
		// System.out.println(ar2);

		ar2.add(new Music("1", "1"));
		ar2.add(new Music("2", "2"));
		ar2.add(new Music("3", "3"));
		ar2.add(new Music("4", "4"));
		ar2.add(3, new Music("a", "a"));

		ar2.add(6, new Music("b", "b"));

		System.out.println(ar2.toString());
		System.out.println("배열 크기 : " + ar2.size());
		System.out.println("비어 있나요? : " + ar2.isEmpty());
		System.out.println("1번 인덱스 정보 : " + ar2.get(1));

		ar2.remove(1);
		System.out.println("1번 인덱스 삭제후");
		System.out.println(ar2.toString());

		ar2.set(0, new Music("b", "b"));
		System.out.println("0번 인덱스 변경 후");
		System.out.println(ar2.toString());

		ar2.set(3, new Music("x", "x"));
		System.out.println("3번 인덱스 변경 후");
		System.out.println(ar2.toString());
	}

	// 배열의 마지막 위치에 매개변수로 전달받은 Music m을 추가하는 함수
	public void add(Music m) {
		if (size == mArr.length) {
			mArr = Arrays.copyOf(mArr, size + 1);
		}
		mArr[size++] = m;
	}

	// 배열의 index 위치에 전달받은 Music m을 추가하는 함수
	public void add(int index, Music m) {
		// 1) 배열의 범위를 벗어난 index 제시시
		// 출력문 : 저장 가능한 인덱스 위치가 아닙니다.

		if (index >= size || index < 0) {
			System.err.println("저장 가능한 인덱스 위치가 아닙니다.");
			return;
		}

		// 2) 배열의 저장공간이 꽉찬경우 배열의 크기 증가.

		if (size == mArr.length) {
			mArr = Arrays.copyOf(mArr, size + 1);
		}
		// 3) index 위치에 값을 저장시 이미 값이들어가 있다면 한칸씩 뒤로 밀어줘야함.
		// [1,2,3,4,5] => 3번 인덱스에 10이라는 값을 넣고 싶다?
		// [1,2,3,10,4,5]
		// 1,2,3,4,5,6 -> 3번
		// 1 2 3 10 4 5 6

		// 3-1) 반복문 활용
		// 상단에서 크기가 꽉찰시 사이즈가 1 커지고
		// [1,2,3,4,5] -> [1,2,3,4,5,0] 으로 초기화 되는 것을 활용
		// 0으로 초기화된 부분 부터 역순으로 돌아가서 저장 하는 방식

		/*
		 * for(int i = size ; i > index ; i--) { mArr[i] = mArr[i-1]; } mArr[index] = m;
		 * size++;
		 */

		// 3-2) 배열복사를 통한 뒤로 밀어주기
		// System.arraycopy(원본배열 , 원본에서 복사를 시작할 인덱스 , 복사본 배열 , 복사본 배열에서 시작할 인덱스 , 복사할
		// 갯수)
		System.arraycopy(mArr, index, mArr, index + 1, size - index);

		mArr[index] = m;
		size++;
	}

	// 배열 내부의 "초기화된" 데이터만 문자열로 반환 하는 함수
	// []
	// [ "1234" , "5678" ]
	public String toString() {
		//
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		// 반복문을 돌리면서 초기화된 데이턱의 toString() 호출
		for (int i = 0; i < size; i++) {
			sb.append(mArr[i].toString());
			sb.append(i != (size - 1) ? "," : ""); // 다음값이 있다면 , 없으면 공백
		}
		sb.append("]");

		return sb.toString();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Music get(int index) {
		if (index >= size || index < 0) {
			System.err.println("잘못된 인덱스 위치");
			return null;
		} else {
			return mArr[index];
		}
	}

	public Music remove(int index) {
		if (index >= size || index < 0) {
			System.err.println("잘못된 인덱스 위치");
			return null;
		}
		Music temp = mArr[index];
		
		// 항상 빈공간을 채우기위해 , index 뒤쪽의 값을 땡겨오는 코드가 있음.
		// 1. 반복문을 활용 한 떙기기
		// [m1, m2, m3, m4, m5] -> [m1, m2, m4 , m5] (2번 인덱스 제거)
		for(int i = index; i < size-1 ; i++) {
			mArr[i] = mArr[i+1];
		}
		mArr[size-1] = null;
		size--;
		
		// 2. 배열 복사?
		
		return temp;

	}

	public Music set(int index, Music m) {
		if (index >= size || index < 0) {
			System.err.println("잘못된 인덱스 위치");
			return null;
		}
		Music temp = mArr[index];
		mArr[index] = m;
		return temp;

	}
}
