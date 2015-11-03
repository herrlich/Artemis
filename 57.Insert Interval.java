/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        boolean flag = false;
        for (int i = 0; i < intervals.size(); ++i) {
            if (intervals.get(i).end < newInterval.start) res.add(intervals.get(i));
            else {
                if (!flag) {
                    res.add(newInterval);
                    flag = true;
                }
                if (intervals.get(i).start <= newInterval.end) {
                    newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                    newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
                }
                else res.add(intervals.get(i));
            }
        }
        if (!flag) res.add(newInterval);
        return res;
    }
}