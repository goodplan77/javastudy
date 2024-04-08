package com.kh.practice.list.music.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.practice.list.music.model.vo.Music;

public class MusicController {

	private List<Music> list = new ArrayList<>();

	public int addList(Music music) {
		boolean result = list.add(music);
		if (result) {
			return 1;
		} else {
			return -1;
		}
	}

	public int addAtZero(Music music) {
		list.add(0, music);
		return 1;

	}

	public List printAll() {
		return this.list;
	}

	public Music searchMusic(String title) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				return list.get(i);
			}
		}

		return null;
	}

	public Music removeMusic(String title) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				return list.remove(i);
			}
		}
		return null;
	}

	public Music setMusic(String title, Music music) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				return list.set(i, music);
			}
		}
		return null;
	}

	public int ascTitle() {
		return 0;
	}

	public int descSinger() {
		return 0;
	}

}
