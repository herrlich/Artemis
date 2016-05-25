public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = 0, repeat = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[len]) {
                if (repeat < 1) {
                    ++repeat;
                    nums[++len] = nums[i];
                }
                else continue;
            }
            else {
                repeat = 0;
                nums[++len] = nums[i];
            }
        }
        return len + 1;
    }
}