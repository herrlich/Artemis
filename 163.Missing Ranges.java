/*
Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"]. 
*/

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            if (lower == upper) res.add(String.valueOf(lower));
            else res.add(lower + "->" + upper);
            return res;
        }
        if (lower < nums[0]) {
            String s;
            if (lower < nums[0] - 1)  s = String.valueOf(lower) + "->" + (nums[0] - 1);
            else s = String.valueOf(lower);
            res.add(s);
        }
        int end = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == end + 1) {
                ++end;
            }
            else {
                String s;
                if (nums[i] == end + 2) s = String.valueOf(end + 1);
                else {
                    s = String.valueOf(end + 1) + "->" + (nums[i] - 1);
                }
                res.add(s);
                end = nums[i];
            }
        }
        if (upper > nums[nums.length - 1]) {
            String s;
            if (upper > nums[nums.length - 1] + 1) s = (nums[nums.length - 1] + 1) + "->" + upper;
            else s = String.valueOf(upper);
            res.add(s);
        }
        return res;
    }
}