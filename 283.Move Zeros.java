public class Solution {
    public void moveZeroes(int[] nums) {
        int p1 = 0, p2 = 0;
        for (p2 = 0; p2 < nums.length; ++p2) {
            if (nums[p2] != 0) nums[p1++] = nums[p2];
        }
        for (; p1 < nums.length; ++p1) nums[p1] = 0;
    }
}