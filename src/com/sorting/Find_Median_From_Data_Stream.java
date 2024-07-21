package com.sorting;

import java.util.PriorityQueue;

public class Find_Median_From_Data_Stream {

	public static void main(String[] args) {
		MedianFinder medianFinder = new MedianFinder();
		medianFinder.addNum(1); // arr = [1]
		medianFinder.addNum(2); // arr = [1, 2]
		System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
		medianFinder.addNum(3); // arr[1, 2, 3]
		System.out.println(medianFinder.findMedian()); // return 2.0
	}

}

class MedianFinder {

	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;

	public MedianFinder() {
		this.minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
		this.maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
	}

	public void addNum(int num) {
		// Adding num
		if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
			maxHeap.add(num);
		} else {
			minHeap.add(num);
		}
		// Rebalancing heaps
		if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.add(maxHeap.poll());
		} else if (maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}

	public double findMedian() {
		if (maxHeap.size() == minHeap.size()) {
			return (maxHeap.peek() + minHeap.peek()) / 2;
		}
		return maxHeap.peek();
	}
}
