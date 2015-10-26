public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int tmp = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (tmp < 0) tmp = 0;
            tmp += nums[i];
            sum = Math.max(tmp, sum);
        }
        sum = Math.max(tmp, sum);
        return sum;
    }
}

//divide and conquer
public class Solution {
    public static int maxSubArray(int[] nums) {
        return divideSubArray(nums, 0, nums.length - 1);
    }
    public static int divideSubArray(int[] nums, int start, int end) {
    	if (start == end) return nums[start];
    	if (start == end - 1) {
    		int max = nums[start];
    		max = Math.max(max, nums[end]);
    		max = Math.max(max, nums[start] + nums[end]);
    		return max;
    	}
    	int mid = (start + end) / 2;
    	int leftmax = divideSubArray(nums, start, mid);
    	int rightmax = divideSubArray(nums, mid + 1, end);
    	int midmax = nums[mid];
    	int tmp = midmax;
    	for (int i = mid - 1; i >= start; --i) {
    		tmp += nums[i];
    		midmax = Math.max(midmax, tmp);
    	}
    	tmp = midmax;
    	for (int i = mid + 1; i <= end; ++i) {
    		tmp += nums[i];
    		midmax = Math.max(midmax, tmp);
    	}
        return Math.max(midmax, Math.max(leftmax, rightmax));
    }
}