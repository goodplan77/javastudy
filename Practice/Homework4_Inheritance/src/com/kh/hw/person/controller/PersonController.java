package com.kh.hw.person.controller;

import com.kh.hw.person.model.vo.Employee;
import com.kh.hw.person.model.vo.Student;

public class PersonController {

	private Student[] s = new Student[3];
	private Employee[] e = new Employee[10];

	public int[] personCount() {
		int studentCount = 0;
		int empolyeeCount = 0;

		for (Student temp1 : s) {
			if (temp1 != null) {
				studentCount++;
			}
		}

		for (Employee temp2 : e) {
			if (temp2 != null) {
				empolyeeCount++;
			}
		}

		int[] personCount = new int[2];
		personCount[0] = studentCount;
		personCount[1] = empolyeeCount;

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
		return s;
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
		return e;
	}

}
