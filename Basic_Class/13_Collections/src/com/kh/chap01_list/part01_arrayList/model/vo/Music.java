package com.kh.chap01_list.part01_arrayList.model.vo;

public class Music implements Comparable<Music>{
	
	private String title;
	private String artist;
	
	public Music() {
		
	}

	public Music(String title, String artist) {
		super();
		this.title = title;
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "Music [title=" + title + ", artist=" + artist + "]";
	}

	@Override
	public int compareTo(Music o) {
		// 값과 값간의 비교. 현재 객체(this)와 매개변수로 들어온 객체 (Music o) 중 뭐가 더 큰가?
		/*
		 * 양수	: 자리 유지
		 * 0	: 자리 유지
		 * 음수	: 자리 교체 
		 */
		int result = this.title.compareTo(o.title);
		if(result==0) {
			result = this.artist.compareTo(o.artist); // 아티스트기준 오름차순 정렬
			//this(현재객체가 앞에오면) 오름차순 , 매개변수로 들어가면 내림차순.
		}
		// o.title.compareTo(this.title); // 내림차순정렬.
		return result;
	}
	
}
