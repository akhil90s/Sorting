package com.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 1, 1, 1, 1, 2, 2, 3, 3, 3 };
		int k = 2;
		int[] result = topKFrequent(nums, k);
		System.out.println(result);

	}

	public static int[] topKFrequent(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> map.get(a) - map.get(b));
		for (int n : map.keySet()) {
			minHeap.add(n);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		result.addAll(minHeap);
		return result.stream().mapToInt(Integer::intValue).toArray();
	}

}
