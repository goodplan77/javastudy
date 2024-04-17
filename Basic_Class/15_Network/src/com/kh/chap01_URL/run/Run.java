package com.kh.chap01_URL.run;

import com.kh.chap01_URL.part01_basic.Network;
import com.kh.chap01_URL.part02_WebCrawl.WebCrawler;

public class Run {

	public static void main(String[] args) {
		Network n = new Network();
		// n.iNetTest();
		n.urlConnection();
		
		WebCrawler w = new WebCrawler();
		w.WebCrawling();
	}

}
