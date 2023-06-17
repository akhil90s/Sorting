package com.sorting;

import java.util.ArrayList;
import java.util.List;

public class Majority_Element_II {

	public static void main(String[] args) {

		int[] nums = new int[] { 3, 2, 3, 3, 5, 5, 5 };
		List<Integer> result = majorityElement(nums);
		System.out.println(result);

	}

	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return result;
		int num1 = -1;
		int num2 = -2;
		int count1 = 0;
		int count2 = 0;
		for (int num : nums) {
			if (count1 == 0) {
				num1 = num;
				count1 = 1;
			} else if (count2 == 0) {
				num2 = num;
				count2 = 1;
			} else if (num1 == num) {
				count1++;
			} else if (num2 == num) {
				count2++;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int num : nums) {
			if (num1 == num) {
				count1++;
			}
			if (num2 == num) {
				count2++;
			}
		}
		if (count1 > nums.length / 3) {
			result.add(num1);
		}
		if (count2 > nums.length / 3) {
			result.add(num2);
		}
		return result;
	}

}
