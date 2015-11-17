public class Solution {
    public int singleNumber(int[] nums) {
        int bit = 0;
        for (int i = 0; i < nums.length; ++i) bit ^= nums[i];
        return bit;
    }
}