package com.kh.practice.book.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import com.kh.practice.book.model.vo.Book;

public class BookDAO {

	private Book[] bArr = new Book[10];

	public void fileSave(Book[] bArr) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.txt"))) {
			for (Book temp : bArr) {
				if (temp != null) {
					oos.writeObject(temp);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Book[] fileRead() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.txt"))) {
			int index = 0;
			while(true) {
				int i = index++;
				// 만약 index 크기가 bArr 의 길이와 같아진다면?
				if(i == bArr.length) {
					bArr = Arrays.copyOf(bArr,i+1); // 배열의 크기를 1증가시켜서 자기자신에게 다시 대입
				}
				bArr[i] = (Book)ois.readObject();
			}

		} catch (EOFException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return bArr;
	}

}
