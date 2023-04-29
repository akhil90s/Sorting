package com.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Find_K_Closest_Elements {

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		List<Integer> result = findClosestElements(arr, 4, 3);
		System.out.println(result);

	}

	// Max Heap
	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> result = new ArrayList<>();
		if (arr == null || arr.length == 0) {
			return result;
		}
		PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.diff == o2.diff) {
					return o2.val - o1.val;
				} else {
					return o2.diff - o1.diff;
				}
			}
		});
		for (int num : arr) {
			maxHeap.add(new Pair(num, Math.abs(num - x)));
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		maxHeap.forEach(p -> result.add(p.val));
		return result.stream().sorted().collect(Collectors.toList());
	}

}

class Pair {

	int val;
	int diff;

	public Pair(int val, int diff) {
		this.val = val;
		this.diff = diff;
	}

	@Override
	public String toString() {
		return "Pair [val=" + val + ", diff=" + diff + "]";
	}

}