package com.kh.chap04_assist.part02_object.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.chap04_assist.part02_object.model.vo.Phone;

public class ObjectsDao {

	public void fileSave() {
		Phone[] pArr = new Phone[3];
		pArr[0] = new Phone("아이폰", 2000000);
		pArr[1] = new Phone("갤럭시", 1000000);
		pArr[2] = new Phone("플립폰", 500000);

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("phones.txt"))) {
			// oos.writeObject(pArr); // 폰 객체 "배열" 저장 => 역직렬화 후 (Phone [])
			for (Phone p : pArr) {
				oos.writeObject(p); // 폰 객체 저장. => 역직렬화시 (Phone)
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void fileRead() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("phones.txt"))) {
			/*
			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
			System.out.println(ois.readObject());
			System.out.println(ois.readObject()); // EOFException 발생
			*/

			while (true) {
				System.out.println(ois.readObject());
			}
		} catch(EOFException e) {
			System.out.println("파일을 다 읽었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
