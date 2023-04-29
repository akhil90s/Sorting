package com.sorting;

import java.util.Arrays;

public class Boats_To_Save_People {

	public static void main(String[] args) {

		int[] people = new int[] { 3, 5, 3, 4 };
		int limit = 5;
		int result = numRescueBoats(people, limit);
		System.out.println(result);

	}

	public static int numRescueBoats(int[] people, int limit) {
		int numsBoat = 0;
		if (people == null || people.length == 0) {
			return numsBoat;
		}
		Arrays.sort(people);
		int start = 0;
		int end = people.length - 1;
		while (start <= end) {
			if (people[start] + people[end] <= limit) {
				start++;
				end--;
			} else {
				end--;
			}
			numsBoat++;
		}
		return numsBoat;
	}

}
