package com.kh.practice.generics.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.practice.generics.model.vo.Farm;

public class FarmController {

	private HashMap<Farm, Integer> hMap = new HashMap<>();
	private ArrayList<Farm> list = new ArrayList<>();

	public boolean addNewKind(Farm f, int amount) {
		if (hMap.containsKey(f)) {
			return false;
		} else {
			hMap.put(f, amount);
			return true;
		}
	}

	public boolean removeKind(Farm f) {
		if (hMap.containsKey(f)) {
			hMap.remove(f);
			return true;
		} else {
			return false;
		}

	}

	public boolean changeAmount(Farm f, int amount) {
		if (hMap.containsKey(f)) {
			return false;
		} else {
			hMap.replace(f, amount);
			return true;
		}
	}

	public HashMap<Farm, Integer> printFarm() {
		return hMap;

	}

	public boolean buyFarm(Farm f) {
		if (hMap.containsKey(f) && hMap.get(f) >= 0) {
			list.add(f);
			hMap.replace(f, hMap.get(f) - 1);
			return true;
		} else {
			return false;
		}

	}

	public boolean removeFarm(Farm f) {
		if (list.contains(f)) {
			list.remove(f);
			hMap.replace(f, hMap.get(f) + 1);
			return true;
		} else {
			return false;
		}

	}

	public ArrayList<Farm> printBuyFarm() {
		return list;
	}

}
