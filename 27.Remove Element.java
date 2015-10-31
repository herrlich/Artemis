public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0, end = nums.length - 1;
        while (start <= end && nums[end] == val) --end;
        while (start <= end) {
            if (nums[start] == val) {
                nums[start] = nums[end--];
                while (start <= end && nums[end] == val) --end;
            }
            ++start;
        }
        return end + 1;
    }
}