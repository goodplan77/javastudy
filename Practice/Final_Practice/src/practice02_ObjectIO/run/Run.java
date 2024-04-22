package practice02_ObjectIO.run;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import practice02_ObjectIO.model.vo.Student;

/*
 * 객체 생성 및 입 출력 시나리오
 * 1. 객체 생성 및 파일 입력 시나리오 (역직렬화)
 * 2. 객체 파일 출력 시나이로 (직렬화)
 * + 객체 배열 생성시 시나리오
 */

public class Run {
	
	Student student1 = new Student("강경호" , 30 , 100);

	public static void main(String[] args) {
		
		Run run = new Run();
		run.ObjectWrite();
		run.ObjectRead();
	}
	
	// 객체 읽어 들이기
	// 파일 -> 프로그램
	// 역직렬화
	public void ObjectRead() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream (new File("test2.txt")))) {
			Student temp1 = (Student)(ois.readObject());
			System.out.println(temp1.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 객체 쓰기
	// 프로그램 -> 파일
	// 직렬화
	public void ObjectWrite() {
		
		try (ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream (new File("test2.txt")));) {
			oos.writeObject(student1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
