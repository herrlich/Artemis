public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = getRange(nums, target, 0, nums.length);
        return res;
    }
    
    public int[] getRange(int[] nums, int target, int start, int end) {
        if (start == end || nums[start] > target || nums[end - 1] < target) {
            int[] res = {-1, -1};
            return res;
        }
        int[] res = new int[2];
        if (nums[start] == target && nums[end - 1] == target) {
            res[0] = start;
            res[1] = end - 1;
            return res;
        }
        int mid = (start + end) / 2;
        int[] left = getRange(nums, target, start, mid);
        int[] right = getRange(nums, target, mid, end);
        if (left[0] != -1 && right[0] != -1) {
            res[0] = left[0];
            res[1] = right[1];
        }
        else {
            if (left[0] != -1) res = left;
            else res = right;
        }
        return res;
    }
}