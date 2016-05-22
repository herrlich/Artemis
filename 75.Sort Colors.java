public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int num1 = 0, num2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) ++num1;
            if (nums[i] == 2) ++num2;
        }
        int i = 0;
        for (; i < nums.length - num1 - num2; ++i) nums[i] = 0;
        for (; i < nums.length - num2; ++i) nums[i] = 1;
        for (; i < nums.length; ++i) nums[i] = 2;
    }
}

//Another Method
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0, right = nums.length - 1;
        int i = left;
        while (i <= right) {
            if (nums[i] == 1) {
                ++i;
                continue;
            }
            if (nums[i] == 0) {
                int tmp = nums[left];
                nums[left++] = 0;
                nums[i++] = tmp;
            }
            else {
                int tmp = nums[right];
                nums[right--] = 2;
                nums[i] = tmp;
            }
        }
    }
}

//Another one using for loop
public class Solution {
    public void sortColors(int[] nums) {
        int p1 = 0, p2 = nums.length - 1;
        for (int i = 0; i < nums.length; ++i) {
            if (i > p2) break;
            if (nums[i] == 0) {
                nums[i] = nums[p1];
                nums[p1++] = 0;
                continue;
            }
            if (nums[i] == 2) {
                nums[i--] = nums[p2];
                nums[p2--] = 2;
                continue;
            }
        }
    }
}