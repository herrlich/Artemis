public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int maxpos = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > maxpos) return false;
            maxpos = Math.max(maxpos, i + nums[i]);
            if (maxpos >= nums.length - 1) return true;
        }
        return true;
    }
}

------------------------------------------------------------------------
Standard Answer

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int pos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0 ; --i) {
            if (i + nums[i] >= pos) pos = i;
        }
        return pos == 0;
    }
}