package com.sorting;

import java.util.PriorityQueue;

public class Kth_Largest_Element_In_An_Array {

	public static void main(String[] args) {

		int[] nums = new int[] { 3, 2, 1, 5, 6, 4 };
		int result = findKthLargest(nums, 2);
		System.out.println(result);

	}

	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for (int num : nums) {
			minHeap.add(num);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		return minHeap.poll();
	}

}
