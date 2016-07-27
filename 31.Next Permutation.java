public class Solution {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 1; --i) {
            if (nums[i - 1] >= nums[i]) continue;
            else {
                for (int j = nums.length - 1; j >= i; --j) {
                    if (nums[j] > nums[i - 1]) {
                        int tmp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = tmp;
                        break;
                    }
                }
                reverse(nums, i, nums.length - 1);
                return;
            }
        }
        reverse(nums, 0, nums.length - 1);
    }
    
    public void reverse(int[] nums, int start, int end) {
        for (int i = 0; i <= (end - start) / 2; ++i) {
            int tmp = nums[start + i];
            nums[start + i] = nums[end - i];
            nums[end - i] = tmp;
        }
    }
}