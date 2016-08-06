public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int val = 0;
        for (int i = 0; i < nums.length; ++i) val ^= nums[i];
        int flag = val & (~(val - 1));
        for (int i = 0; i < nums.length; ++i) {
            if ((nums[i] & flag) == 0) {
                res[0] ^= nums[i];
            }
            else res[1] ^= nums[i];
        }
        return res;
    }
}