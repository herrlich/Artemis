public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int p1 = 0, p2 = 1;
        for (; p2 < nums.length; ++p2) {
            if (nums[p2] == nums[p1]) continue;
            else nums[++p1] = nums[p2];
        }
        return p1 + 1;
    }
}