package com.sorting;

public class Majority_Element_I {

	public static void main(String[] args) {

		int[] nums = new int[] { 2, 2, 1, 1, 1, 2, 2 };
		int result = majorityElement(nums);
		System.out.println(result);

	}

	// Moore's Voting Algorithm
	public static int majorityElement(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int result = 0;
		int count = 0;
		for (int num : nums) {
			if (count == 0) {
				result = num;
			}
			if (num == result) {
				count++;
			} else {
				count--;
			}
		}
		return result;
	}

}
