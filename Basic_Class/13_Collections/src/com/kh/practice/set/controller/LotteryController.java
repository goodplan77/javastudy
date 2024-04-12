package com.kh.practice.set.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

import com.kh.practice.set.compare.SortedLottery;
import com.kh.practice.set.model.vo.Lottery;

public class LotteryController {

	private HashSet<Lottery> lottery = new HashSet<>();
	private HashSet<Lottery> win = new HashSet<>();

	public boolean insertObject(Lottery l) {
		return lottery.add(l);
	}

	public boolean deleteObject(Lottery l) {
		boolean result = lottery.remove(l);

		if (result && !win.isEmpty()) {
			win.remove(l);
		}

		return result;
	}

	public HashSet winObject() {
		ArrayList<Lottery> list = new ArrayList<>();
		list.addAll(lottery);

		// 1) shuffle
		// 2) Math.random()

		if (list.size() < 4) {
			return null;
		}

		for (int i = 0; i < 4; i++) {
			int randomIndex = (int) (Math.random() * list.size());
			Lottery l = list.get(randomIndex);
			
			if(win.size() >= 4) {
				break;
			}

			boolean result = win.add(l);

			if (!result) {
				i--;
				continue;
			}
		}
		
		return win;

	}

	public TreeSet sortedWinObject() {
		winObject();
		
		// 1. 클래스를 생성해서 Comparator 를 호출 하는 방법
		/*
		class Sol implements Comparator<Lottery> {

			@Override
			public int compare(Lottery o1, Lottery o2) {
				int result = o1.getName().compareTo(o2.getName());
				
				if(result == 0) {
					result =  o1.getPhone().compareTo(o2.getPhone());
				}
				
				return result;
			}
			
		}
		*/
		
		
		// 2. 익명 클래스를 활용하여 호출하는 방법
		/*
		TreeSet<Lottery> temp = new TreeSet<>(new Comparator<Lottery>() {

			@Override
			public int compare(Lottery o1, Lottery o2) {
				int result = o1.getName().compareTo(o2.getName());
				
				if(result == 0) {
					result =  o1.getPhone().compareTo(o2.getPhone());
				}
				
				return result;
			}
		});
		*/
		
		TreeSet<Lottery> temp = new TreeSet<>(new SortedLottery());
		temp.addAll(win);
		return temp;
	}
	

	public boolean searchWinner(Lottery l) {
		return win.contains(l);
	}

}
