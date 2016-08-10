/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return 2. 
*/

//Finding the maximum overlapped intervals

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

//Method using min heap
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
           });
        PriorityQueue<Integer> min_heap = new PriorityQueue<Integer>();
        min_heap.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i].start < min_heap.peek()) min_heap.offer(intervals[i].end);
            else {
                min_heap.poll();
                min_heap.offer(intervals[i].end);
            }
        }
        return min_heap.size();
    }
}

//My previous method
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int len = intervals.length;
        int[] start = new int[len];
        int[] end = new int[len];
        for (int i = 0; i < len; ++i) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int p1 = 0, p2 = 0;
        int res = 0, maxroom = 0;
        while (p1 < len) {
            if (start[p1] < end[p2]) {
                ++res;
                ++p1;
            }
            else {
                if (start[p1] > end[p2]) {
                    --res;
                    ++p2;
                }
                else {
                    ++p1;
                    ++p2;
                }
            }
            maxroom = Math.max(res, maxroom);
        }
        return maxroom;
    }
}