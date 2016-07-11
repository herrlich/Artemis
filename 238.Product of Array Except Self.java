public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; ++i) res[i] = 1;
        int tmp = 1;
        for (int i = 0; i < nums.length - 1; ++i) {
            res[i] *= tmp;
            tmp *= nums[i];
        }
        res[nums.length - 1] = tmp;
        tmp = 1;
        for (int i = nums.length - 1; i >= 1; --i) {
            res[i] *= tmp;
            tmp *= nums[i];
        }
        res[0] = tmp;
        return res;
    }
}