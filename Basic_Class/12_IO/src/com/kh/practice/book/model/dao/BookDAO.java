package com.kh.practice.book.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
			for (Book temp : bArr) {
				temp = (Book)ois.readObject();
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
