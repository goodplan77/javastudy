package com.kh.practice.list.music.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.kh.practice.list.music.model.compare.AscTitle;
import com.kh.practice.list.music.model.vo.Music;

public class MusicController {

	private List list = new ArrayList();

	public int addList(Music music) {
		try {
			list.add(music);
			return 1;
		} catch (Exception e) { // 데이터 추가시 오류가 발생?
			return 0;
		}
	}

	public int addAtZero(Music music) {
		try {
			list.add(0, music); // 비효율적? LinkedList? 사용 권장?
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public List printAll() {
		return this.list;
	}

	public Music searchMusic(String title) {
		for (int i = 0; i < list.size(); i++) {
			if (((Music)list.get(i)).getTitle().equals(title)) {
				return (Music)list.get(i);
			}
		}
		
		return null;
	}

	public Music removeMusic(String title) {
		for (int i = 0; i < list.size(); i++) {
			if (((Music)list.get(i)).getTitle().equals(title)) {
				return (Music)list.remove(i);
			}
		}
		return null;
	}

	public Music setMusic(String title, Music music) {
		for (int i = 0; i < list.size(); i++) {
			if (((Music)list.get(i)).getTitle().equals(title)) {
				return (Music)list.set(i, music);
			}
		}
		return null;
	}

	public int ascTitle() {
		Collections.sort(list , new AscTitle());
		return 1;
	}

	public int descSinger() {
		Collections.sort(list);
		return 1;
	}

}
