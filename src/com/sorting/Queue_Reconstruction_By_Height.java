package com.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Queue_Reconstruction_By_Height {

	public static void main(String[] args) {

		// { { 5, 0 }, { 7, 0 }, { 5, 2 }, { 6, 1 }, { 4, 4 }, { 7, 1 } }
		int[][] people = new int[][] { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		int[][] result = reconstructQueue(people);
		System.out.println(result);

	}

	public static int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] == b[0])
					return a[1] - b[1];
				return b[0] - a[0];
			}
		});
		List<int[]> result = new ArrayList<>();
		for (int[] p : people) {
			result.add(p[1], p);
		}
		return result.toArray(new int[people.length][2]);
	}

}
