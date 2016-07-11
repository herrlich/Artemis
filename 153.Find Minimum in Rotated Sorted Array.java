public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        while (left != right) {
            int mid = left + (right - left) / 2;
            if (nums[right] > nums[mid]) right = mid;
            else left = mid + 1;
        }
        return nums[left];
    }
}