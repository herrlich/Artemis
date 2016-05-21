public class Solution {
    public int firstMissingPositive(int[] nums) {
        int pos = 0;
        while (pos < nums.length) {
            if (nums[pos] > 0 && nums[pos] < nums.length && (nums[pos] != pos + 1) && (nums[nums[pos] - 1] != nums[pos])) {
                int tmp = nums[pos];
                nums[pos] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
            else ++pos;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}