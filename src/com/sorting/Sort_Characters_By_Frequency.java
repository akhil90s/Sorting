package com.sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Sort_Characters_By_Frequency {

	public static void main(String[] args) {

		String s = "tree";
		String result = frequencySort(s);
		System.out.println(result);
		
	}

	public static String frequencySort(String s) {
		StringBuilder result = new StringBuilder();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		PriorityQueue<Character> pq = new PriorityQueue<Character>((a, b) -> map.get(b) - map.get(a));
		pq.addAll(map.keySet());
		while (!pq.isEmpty()) {
			char c = pq.poll();
			for (int i = 0; i < map.get(c); i++) {
				result.append(c);
			}
		}
		return result.toString();
	}
	
}
