package package3.controller;

import package3.model.vo.*;

public class AnimalManager {

	public static void main(String[] args) {

		Animal[] animals = new Animal[5];
		animals[0] = new Dog("개1", "진돗개", 10);
		animals[1] = new Cat("냥1", "랙돌", "집", "흰색");
		animals[2] = new Dog("개2", "시바견", 11);
		animals[3] = new Cat("냥2", "러시안블루", "집", "파란색");
		animals[4] = new Dog("개3", "치와와", 5);

		for (Animal temp : animals) {
			temp.speak();
		}
	}
}
