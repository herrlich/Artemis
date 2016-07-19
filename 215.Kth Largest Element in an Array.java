public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return divideArray(nums, 0, nums.length - 1, k);
    }
    
    public int divideArray(int[] nums, int start, int end, int k) {
        int flag = nums[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && nums[right] <= flag) --right;
            nums[left] = nums[right];
            while (left < right && nums[left] > flag) ++left;
            nums[right] = nums[left];
        }
        nums[left] = flag;
        if (left - start == k - 1) return nums[left];
        if (left - start > k - 1) return divideArray(nums, start, left - 1, k);
        else return divideArray(nums, left + 1, end, k - 1 - left + start);
    }
}