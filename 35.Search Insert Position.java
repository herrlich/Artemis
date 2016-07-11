public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        //if (target > nums[nums.length - 1]) return nums.length;
        //if (target <= nums[0]) return 0;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        if (nums[start] >= target) return start;
        else return start + 1;
    }
}