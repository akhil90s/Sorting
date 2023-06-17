package com.sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class Third_Maximum_Number {

	public static void main(String[] args) {

		int[] nums = new int[] { 3, 2, 1 };
		int result_Approach1 = thirdMax_Approach1(nums);
		System.out.println(result_Approach1);

		int result_Approach2 = thirdMax_Approach2(nums);
		System.out.println(result_Approach2);

	}

	public static int thirdMax_Approach1(int[] nums) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		Set<Integer> set = new HashSet<Integer>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
		for (int num : set) {
			minHeap.add(num);
			if (minHeap.size() > 3) {
				minHeap.poll();
			}
		}
		if (minHeap.size() == 2) {
			minHeap.poll();
		}
		return minHeap.poll();
	}

	public static int thirdMax_Approach2(int[] nums) {
		Integer max1 = null;
		Integer max2 = null;
		Integer max3 = null;
		for (Integer n : nums) {
			if (n.equals(max1) || n.equals(max2) || n.equals(max3))
				continue;
			if (max1 == null || n > max1) {
				max3 = max2;
				max2 = max1;
				max1 = n;
			} else if (max2 == null || n > max2) {
				max3 = max2;
				max2 = n;
			} else if (max3 == null || n > max3) {
				max3 = n;
			}
		}
		return max3 == null ? max1 : max3;
	}

}
