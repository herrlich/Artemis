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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) return res;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        Interval tmp = intervals.get(0);
        res.add(tmp);
        for (int i = 1; i < intervals.size(); ++i) {
            if (intervals.get(i).start > tmp.end) {
                tmp = intervals.get(i);
                res.add(tmp);
            }
            else {
                tmp.end = Math.max(tmp.end, intervals.get(i).end);
            }
        }
        return res;
    }
}