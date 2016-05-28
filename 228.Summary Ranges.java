public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if (nums == null || nums.length == 0) return list;
        int start = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1] + 1) {
                ++end;
                continue;
            }
            else {
                if (start == end) list.add(String.valueOf(end));
                else list.add(String.valueOf(start) + "->" + String.valueOf(end));
                start = nums[i];
                end = nums[i];
            }
        }
        if (start == end) list.add(String.valueOf(end));
        else list.add(String.valueOf(start) + "->" + String.valueOf(end));
        return list;
    }
}