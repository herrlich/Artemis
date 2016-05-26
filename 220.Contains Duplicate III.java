public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 1) return false;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            int n = nums[i];
            if ((set.floor(n) != null && set.floor(n) >= (long)n - t) || (set.ceiling(n) != null && n >= (long)set.ceiling(n) - t))
                return true;
            // the floor function returns the largest element that is smaller than n
            // the ceiling function returns the smallest element that is larger than n
            if (i >= k) set.remove(nums[i - k]);
            set.add(nums[i]);
        }
        return false;
    }
}