package com.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Meeting_Rooms_II {

	public static void main(String[] args) {

		Interval i1 = new Interval(0, 30);
		Interval i2 = new Interval(5, 10);
		Interval i3 = new Interval(15, 20);
		Interval[] intervals = new Interval[] { i1, i2, i3 };
		int result = minMeetingRooms(intervals);
		System.out.println(result);

	}

	public static int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;
		Arrays.sort(intervals, (a, b) -> a.start - b.start);
		PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>((a, b) -> a.end - b.end);
		minHeap.add(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			Interval curr = intervals[i];
			Interval prev = minHeap.peek();
			if (curr.start >= prev.end) {
				prev.end = curr.end;
			} else {
				minHeap.add(curr);
			}
		}
		return minHeap.size();
	}

}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}