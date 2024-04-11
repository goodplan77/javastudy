package com.kh.chap02_map.part02_cloneMap.run;

import com.kh.chap02_map.part01_hashMap.model.vo.Snack;

public class MapRun {

	class Entry {
		String key;
		Snack value;
		Entry next;

		public Entry(String key, Snack value, Entry next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

	}

	private Entry[] table;
	private int capacity;
	private int size;

	public MapRun(int capacity) {
		this.capacity = capacity;
		table = new Entry[capacity];

	}

	public static void main(String[] args) {
		MapRun mr = new MapRun(10);
		mr.put("다이제", new Snack(("초코맛"), 1500));
		mr.put("다이제", new Snack(("초코맛"), 1500));
		mr.put("칸초", new Snack(("단맛"), 600));
		mr.put("새우깡", new Snack(("짠맛"), 500));
		mr.put("포테이토칩", new Snack(("짠맛"), 500));

		System.out.println(mr);
		System.out.println(mr.size());
		System.out.println(mr.get("다이제"));
		System.out.println(mr.get("칸초"));
		
		System.out.println(mr.conatinsKey("칸초"));
		System.out.println(mr.conatinsKey("칸초2"));
		
		mr.remove("포테이토칩");
		System.out.println(mr.conatinsKey("포테이토칩"));
		System.out.println(mr.size());
		
		mr.remove("칸초");
		System.out.println(mr);
		
	}

	public int getIndex(String key) {
		return Math.abs(key.hashCode() & capacity); // 절대값?

	}

	public void put(String key, Snack value) {
		int index = getIndex(key);
		Entry e = table[index];

		if (e == null) {
			table[index] = new Entry(key, value, null);
		} else {
			if (e.key.equals(key)) {
				e.value = value;
				return; // size 추가 안되게 종료
			} else {
				while (true) {
					if (e.next == null) {
						e.next = new Entry(key, value, null);
						break;
					}

					// next로 뽑은 entry값도 key값이 일치하는지 비교
					if (e.key.equals(key)) {
						e.value = value;
						return;
					}

					e = e.next; // 현재 entry 에 next 값을 저장
				}
			}
		}

		size++;

	}

	public Snack get(String key) {
		int index = getIndex(key);
		Entry e = table[index];

		if (e == null) {
			return null; // 데이터 없음
		}

		do {
			if (e.key.equals(key)) {
				return e.value;
			}
			e = e.next;
		} while (e != null);

		return null;

	}

	public boolean conatinsKey(String key) {
		int index = getIndex(key);
		Entry e = table[index];

		if (e == null) {
			return false; // 데이터 없음
		}

		do {
			if (e.key.equals(key)) {
				return true;
			}
			e = e.next;
		} while (e != null);
		
		return false;

	}

	public void remove(String key) {
		int index = getIndex(key);
		Entry e = table[index];
		
		if(e == null) {
			return;
		}
		Entry pre = null;
		do {
			if (e.key.equals(key)) {
				if(e == table[index]) {
					table[index] = (e.next == null ? null : e.next);
				} else {
					pre.next = e.next;
				}
				size--;
				break;
			}
			pre = e;
			e = e.next;
		} while (e != null);

	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('{');
		for (Entry e : table) {
			if (e == null) {
				continue;
			}

			sb.append("[");
			sb.append(e.key + " : " + e.value);
			sb.append("]");
			sb.append(",");

			Entry next = e.next;

			do {
				if (next != null) {
					sb.append("[");
					sb.append(next.key + " : " + next.value);
					sb.append("]");
					sb.append(",");
					next = next.next;
				}
			} while (next != null);
			
		}
		sb.append('}');

		return sb.toString();
	}
}
