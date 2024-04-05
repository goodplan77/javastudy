package com.kh.practice.score.model.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreDAO {
	public void saveScore(String name, int kor, int eng, int math, int sum, double avg) {
		File f = new File("ScoreData.txt");
		FileWriter fw = null;
				
		try {
			fw = new FileWriter(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public DataInputStream readScore() throws FileNotFoundException {
		return null;
	}
}
