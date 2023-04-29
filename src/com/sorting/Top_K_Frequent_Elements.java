package com.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 1, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5 };
		int k = 2;
		int[] result_MinHeap = topKFrequent_MinHeap(nums, k);
		System.out.println(result_MinHeap);

		int[] result_MaxHeap = topKFrequent_MaxHeap(nums, k);
		System.out.println(result_MaxHeap);

	}

	// Using Min Heap
	public static int[] topKFrequent_MinHeap(int[] nums, int k) {
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

	// Using Max Heap
	public static int[] topKFrequent_MaxHeap(int[] nums, int k) {
		if (nums.length == 0 || nums == null) {
			return new int[0];
		}
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> map.get(b) - map.get(a));
		map.keySet().forEach(key -> maxHeap.add(key));
		for (int i = 0; i < k; i++) {
			result.add(maxHeap.poll());
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}

}
