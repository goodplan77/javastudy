package com.kh.practice.list.music.model.vo;

public class Music implements Comparable{

	private String title;
	private String singer;

	public Music() {
	}

	public Music(String title, String singer) {
		super();
		this.title = title;
		this.singer = singer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		return singer + " - " + title;
	}

	@Override
	public int compareTo(Object o) {
		Music temp = (Music) o;
		return temp.getSinger().compareTo(this.singer);
	}

}
