package com.kh.chap01_beforeVsAfter.after.model.vo;

public class Desktop extends Product {

	private boolean allInOne;

	public Desktop() {

	}

	public Desktop(String brand, String pCode, String pName, int price, boolean allInOne) {
		// brand , pCode , pName , price는 Product에 존재하는 필드
		
		// 1. 필드의 접근제한자가 protected으로 설정 된 경우 필드에 직접 대입 하는 방법
		// super.brand = brand
		
		// 2. public 접근 제한자인 setter 메소드 활용
		// setBrand(brand);
		// setpCode(pCode);
		// setpName(pName);
		// setPrice(price);
		
		// 3. 부모 생성자를 호출하여 필드값 초기화
		super(brand, pCode, pName, price);
		
		// super는 부모 주소값을 가지고 있다.
		// 즉 , super으로 부모에 접근 가능
		this.allInOne = allInOne;
	}

	public boolean isAllInOne() {
		return allInOne;
	}

	public void setAllInOne(boolean allInOne) {
		this.allInOne = allInOne;
	}

	@Override
	public String toString() {
		return super.toString() + ", allInOne : " + allInOne;
	}
}
