public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int len = nums.length + 1;
        int left = 0, right = 0;
        while (right < nums.length) {
            if (sum < s) {
                sum += nums[right];
                ++right;
            }
            else {
                while (sum >= s) {
                    len = Math.min(len, right - left);
                    sum -= nums[left];
                    ++left;
                }
            }
        }
        while (sum >= s) {
            len = Math.min(len, right - left);
            sum -= nums[left];
            ++left;
        }
        if (len == nums.length + 1) return 0;
        else return len;
    }
}


//Another method whose time complexity is O(nlogn)
public class Solution {
    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = nums.length;
        int mid = (left + right) / 2;
        int res = nums.length + 1;
        while (left <= right) {
        	mid = (left + right) / 2;
        	if (fixlength(mid, nums, s)) {
        		res = mid;
        		right = mid - 1;
        	}
        	else left = mid + 1;
        }
        if (res > nums.length) return 0;
        else return res;
    }
    
    public static boolean fixlength(int len, int[] nums, int s) {//this means the length of the subarray is fixed to be len.
    	int sum = 0;
    	for (int i = 0; i < nums.length; ++i) {
    		sum += nums[i];
    		if (i >= len) sum -= nums[i - len];
    		if (sum >= s) return true;
    	}
    	return false;
    }
}