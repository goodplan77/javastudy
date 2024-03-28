package com.kh.hw.employee.employee.controller;

import com.kh.hw.employee.model.vo.Employee;

public class EmployeeController {

	Employee e;

	public void add(int empNo, String name, char gender, String phone) {
		e = new Employee(empNo,name,gender,phone);
	}

	public void add(int empNo, String name, char gender, String phone, String dept, int salary, double bouns) {
		e = new Employee(empNo,name,gender,phone,dept,salary,bouns);
	}

	public void modify(String phone) {
		e.setPhone(phone);
	}

	public void modify(int salary) {
		e.setSalary(salary);
	}

	public void modify(double bouns) {
		e.setBouns(bouns);
	}
	
	public Employee remove() {
		e = null;
		return e;
	}
	
	public String inform() {
		if(e == null) {
			return null;
		} else {
			return e.printEmployee();
		}
	}

}
