package com.kh.chap03_stream.part02_methods;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

public class OptionalMethods {
	
	/*
	 * Optional
	 * - 존재 할 수도 있고 , 안 할 수도 있는 객체를 감싸고 있는 객체
	 * - 변수명에 maybeMember , optUser 와 값이 Optional타입 임을 암묵적으로 제시 해야 한다.
	 * 
	 * Optional 객체 생성 방법.
	 * 1. Optional.empty() : 비어 있는 Optional 객체
	 * -> 필터링을 잘못해서 알맞는 값이 없는 경우
	 * -> NoSuchElementException 에러 발생?
	 * 
	 * 2. Optional.of(obj) : 결코 null 이 아닌 객체를 담은 Optional 객체
	 * 3. Optional.ofNullable(obj) : null 일수도 있는 객체를 담은 Optional 객체
	 * -> 필터링후 맞는 값을 설정한 경우
	 * 
	 * Optional 객체 내부 메소드들
	 * - get() : 값을 반환 (값이 없다면 NoSuchElementException 발생)
	 * - getAs자료형 : 자료형의 값을 반환 (값이 없다면 NoSuchElementException 발생)
	 * - orElse(T) : get() 으로 꺼낼 값이 존재 하지 않을경우 T값 반환
	 * - orElseGet(Supplier) : get() 으로 꺼낼 값이 존재 하지 않을 경우 , 람다식으로 구현한 값을 반환. 
	 * - orElseThrow(Supplier) : get() 으로 꺼낼 값이 존재 하지 않을 경우 , 람다식으로 구현한 에러 객체를 반환.
	 * - isPresent() : boolean 값이 존재하는지 확인후 존재하면 true , 없으면 false
	 * - ifPresent(Consumer) : 값이 존재한다면 스트림 요소값을 실행할 코드 구현.
	 */
	
	public static void main(String[] args) {
		OptionalMethods om = new OptionalMethods();
		//om.test1();
		//om.test2();
		
		// 1) isPresent()
		Optional opt = Optional.empty();
		boolean isPresent = opt.isPresent();
		if(isPresent) {
			System.out.println(isPresent);
		}
		
		// 2) ifPresent(Consumer)
		Optional<Integer> opt2 = Optional.of(1);
		opt2.ifPresent(value -> System.out.println("값이 존재합니다 : " + value));
	
		// 3) orElseGet(Supplier)
		String str = (String)opt.orElseGet(() -> "값이 없네요.");
		System.out.println(str);
	}
	
	public void test2( ) {
		Member member = new Member();
		member.email = "goodplan77@naver.com";
		
		Order order = new Order();
		order.member = member;
		
		Order order2 = null;
		
		Order order3 = new Order();
		
		System.out.println(getEmailFromOrder(order));
		System.out.println(getEmailFromOrder(order2));
		System.out.println(getEmailFromOrder(order3));
	}
	
	public String getEmailFromOrder(Order order) {
		// 기존 반복문을 이용한 이메일 값 반환
		// null 값인지 아닌지 일일이 확인
		/*
		if(order != null) {
			Member member = order.member;
			if(member != null) {
				String email = member.email;
				if(email != null) {
					return email;
				}
			}
		}
		return "이메일이 존재 하지 않습니다";
		*/
		
		/*
		Optional<Order> optOrder = Optional.ofNullable(order);
		// Order -> Member -> String
		return optOrder
				.map(ord -> ord.member)
				.map(mem -> mem.email)
				.orElse("이메일이 존재 하지 않습니다.");
		*/
		
		return Optional.ofNullable(order)
						.map(Order::getMember)
						.map(Member::getEmail)
						.orElse("이메일이 존재 하지 않습니다.");
	}
	
	class Order {
		Member member;
		int count;
		
		public Order () {
			
		}

		public Order(Member member, int count) {
			super();
			this.member = member;
			this.count = count;
		}

		public Member getMember() {
			return member;
		}

		public int getCount() {
			return count;
		}

		public void setMember(Member member) {
			this.member = member;
		}

		public void setCount(int count) {
			this.count = count;
		}

		@Override
		public String toString() {
			return "Order [member=" + member + ", count=" + count + "]";
		}
		
	}
	
	class Member {
		String id;
		String email;
		
		public Member() {
			
		}
		
		public Member(String id , String email) {
			this.id = id;
			this.email = email;
		}

		public String getId() {
			return id;
		}

		public String getEmail() {
			return email;
		}

		public void setId(String id) {
			this.id = id;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "Member [id=" + id + ", email=" + email + "]";
		}
		
	}
	
	public void test1() {
		List<String> list = Arrays.asList("홍길동" , "임꺽정" , null , "");
		
		list.stream()
			.forEach(s -> System.out.println(s + " : " + getStringLength(s))); //s.length 호출에서 문제 발생. null 값 참조
	}
	
	public int getStringLength(String str) {
		Optional<String> maybeStr = Optional.ofNullable(str);
		
		return maybeStr
				.map(s -> s.length())
				//.orElse(0);
				.orElseThrow(() -> new RuntimeException("NULL 값 존재"));
	}

}
