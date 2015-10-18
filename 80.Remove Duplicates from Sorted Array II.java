public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int p1 = 0, p2 = 1;
        boolean flag = false;
        for (; p2 < nums.length; ++p2) {
            if (nums[p2] == nums[p1]) {
                if (flag) continue;
                else {
                    nums[++p1] = nums[p2];
                    flag = true;
                }
            }
            else {
                nums[++p1] = nums[p2];
                flag = false;
            }
        }
        return p1 + 1;
    }
}