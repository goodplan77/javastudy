package com.kh.hw.person.controller;

import java.util.Arrays;

import com.kh.hw.person.model.vo.Employee;
import com.kh.hw.person.model.vo.Student;

public class PersonController {

	private Student[] s = new Student[3];
	private Employee[] e = new Employee[10];

	public int[] personCount() {
		int[] personCount = new int[2];

		for (Student temp1 : s) {
			if (temp1 != null) {
				personCount[0]++;
			}
		}

		for (Employee temp2 : e) {
			if (temp2 != null) {
				personCount[1]++;
			}
		}
		return personCount;
	}

	public void insertStudent(String name, int age, double height, double weight, int grade, String major) {
		for (int i = 0; i <= personCount()[0]; i++) {
			if (s[i] != null) {
				continue;
			} else {
				s[i] = new Student(name, age, height, weight, grade, major);
				personCount();
				break;
			}
		}
	}

	public Student[] printStudent() {
		//깊은 복사를 통한 값만 복사
		Student[] copy1 = new Student[3];
		System.arraycopy(s, 0, copy1, 0, personCount()[0]);
		
		//
		Student[] copy2 = Arrays.copyOf(s, personCount()[0]);
		return copy1;
	}

	public void insertEmployee(String name, int age, double height, double weight, int salary, String dept) {
		for (int i = 0; i <= personCount()[1]; i++) {
			if (e[i] != null) {
				continue;
			} else {
				e[i] = new Employee(name, age, height, weight, salary, dept);
				personCount();
				break;
			}
		}
	}

	public Employee[] printEmployee() {
		Employee[] copy1 = new Employee[10];
		System.arraycopy(e, 0, copy1, 0, personCount()[1]);
		return copy1;
	}

}
