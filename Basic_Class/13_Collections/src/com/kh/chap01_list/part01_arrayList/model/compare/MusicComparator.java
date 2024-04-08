package com.kh.chap01_list.part01_arrayList.model.compare;

import java.util.Comparator;

import com.kh.chap01_list.part01_arrayList.model.vo.Music;

public class MusicComparator implements Comparator<Music>{

	@Override
	public int compare(Music o1, Music o2) {
		//int result = o1.getTitle().compareTo(o2.getTitle()); // 앞에거. 오름차순?
		int result = o2.getTitle().compareTo(o1.getTitle()); // 뒤에거. 내림차순?	
		return result;
	}

}
