package com.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals {

	public static void main(String[] args) {

		int[][] nums = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] result = merge(nums);
		System.out.println(result);

	}

	public static int[][] merge(int[][] intervals) {
		List<int[]> result = new ArrayList<>();
		if (intervals == null || intervals.length == 0) {
			return result.toArray(new int[0][]);
		}
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int start = intervals[0][0];
		int end = intervals[0][1];
		for (int[] interval : intervals) {
			if (interval[0] <= end) {
				end = Math.max(interval[1], end);
			} else {
				result.add(new int[] { start, end });
				start = interval[0];
				end = interval[1];
			}
		}
		result.add(new int[] { start, end });
		return result.toArray(new int[0][]);
	}

}
