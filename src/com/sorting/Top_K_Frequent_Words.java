package com.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequent_Words {

	public static void main(String[] args) {

		// String[] words = new String[] { "i", "love", "leetcode", "i", "love", "coding" };
		String[] words = new String[] { "the","day","is","sunny","the","the","the","sunny","is","is" };
		int k = 4;
		List<String> result = topKFrequent(words, k);
		System.out.println(result);

	}

	public static List<String> topKFrequent(String[] words, int k) {
		List<String> result = new ArrayList<>();
		if (words == null || words.length == 0)
			return result;
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		PriorityQueue<String> maxHeap = new PriorityQueue<String>((a, b) -> {
			int f1 = map.get(a);
			int f2 = map.get(b);
			if (f1 == f2)
				return a.compareTo(b);
			return f2 - f1;
		});
		maxHeap.addAll(map.keySet());
		for (int i = 0; i < k; i++) {
			result.add(maxHeap.poll());
		}
		return result;
	}

}
