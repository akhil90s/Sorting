package com.sorting;

import java.util.PriorityQueue;

public class K_Closest_Points_To_Origin {

	public static void main(String[] args) {

		int[][] points = new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		int k = 2;
		
		int[][] result_MinHeap = kClosest_MinHeap(points, k);
		System.out.println(result_MinHeap);

		int[][] result_MaxHeap = kClosest_MaxHeap(points, k);
		System.out.println(result_MaxHeap);

	}

	// Using MinHeap
	public static int[][] kClosest_MinHeap(int[][] points, int k) {
		PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(
				(a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
		for (int[] point : points) {
			minHeap.add(point);
		}
		int[][] result = new int[k][2];
		for (int i = 0; i < k; i++) {
			result[i] = minHeap.poll();
		}
		return result;
	}

	// Using MaxHeap
	public static int[][] kClosest_MaxHeap(int[][] points, int k) {
		PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(
				(a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
		for (int[] point : points) {
			maxHeap.add(point);
			while (maxHeap.size() > k) {
				maxHeap.remove();
			}
		}
		int[][] result = new int[k][2];
		for (int i = 0; i < k; i++) {
			result[i] = maxHeap.poll();
		}
		return result;
	}

}
