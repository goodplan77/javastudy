package com.kh.practice.score.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.DataInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreDAO {
	public void saveScore(String name, int kor, int eng, int math, int sum, double avg) {
		File f = new File("ScoreData.txt");
		FileWriter fw = null;
				
		try {
			fw = new FileWriter(f);
			fw.write(name);
			fw.write("\t");
			
			fw.write(Integer.toString(kor));
			fw.write("\t");
			
			fw.write(Integer.toString(eng));
			fw.write("\t");
			
			fw.write(Integer.toString(math));
			fw.write("\t");
			
			fw.write(Integer.toString(sum));
			fw.write("\t");
			
			fw.write(Double.toString(avg));
			fw.write("\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public DataInputStream readScore() throws FileNotFoundException {
		File f = new File("ScoreData.txt");
		DataInputStream dis = null;
		
		dis = new DataInputStream(new FileInputStream(f));
		
		return dis;
	}
}
