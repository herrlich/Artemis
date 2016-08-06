Given a sorted array of integers nums and integer values a, b and c. Apply a function of the form f(x) = ax2 + bx + c to each element x in the array. 

The returned array must be in sorted order.

Expected time complexity: O(n)

Example:

nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

Result: [3, 9, 15, 33]

nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

Result: [-23, -5, 1, 7]




public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        
        if (a == 0) {
            if (b > 0) {
                for (int i = 0; i < nums.length; ++i) res[i] = b * nums[i] + c;
            }
            else {
                for (int i = 0; i < nums.length; ++i) res[nums.length - 1 - i] = b * nums[i] + c;
            }
            return res;
        }
        
        int right = 0, left = 0;
        double mid = - b * 1.0 / (2 * a);
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > mid) {
                right = i;
                break;
            }
        }
        if (nums[nums.length - 1] < mid) right = nums.length;
        left = right - 1;
        
        int pos = 0;
        if (a < 0) pos = nums.length - 1;
        
        int step = 1;
        if (a < 0) step = -1;
        
        
        while (left >= 0 || right < nums.length) {
            if (left >= 0 && right < nums.length) {
                if (Math.abs(nums[left] - mid) < Math.abs(nums[right] - mid)) {
                    res[pos] = func(nums[left--], a, b, c);
                    pos += step;
                }
                else{
                    res[pos] = func(nums[right++], a, b, c);
                    pos += step;
                }
            }
            else {
                if (left >= 0) {
                    res[pos] = func(nums[left--], a, b, c);
                    pos += step;
                }
                else {
                    res[pos] = func(nums[right++], a, b, c);
                    pos += step;
                }
            }
        }
        return res;
    }
    
    public int func(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}