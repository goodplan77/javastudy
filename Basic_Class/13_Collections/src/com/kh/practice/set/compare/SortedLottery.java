package com.kh.practice.set.compare;

import java.util.Comparator;
import com.kh.practice.set.model.vo.Lottery;


public class SortedLottery implements Comparator<Lottery>{

	@Override
	public int compare(Lottery o1, Lottery o2) {
		int result = o1.getName().compareTo(o2.getName());
		
		if(result == 0) {
			result =  o1.getPhone().compareTo(o2.getPhone());
		}
		
		return result;
	}

}
