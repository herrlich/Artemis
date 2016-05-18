public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; ++i) {
            int residual = target - nums[i];
            if (map.containsKey(residual)) {
                if (i != map.get(residual)) {
                    int[] res = {i, map.get(residual)};
                    return res;
                }
            }
        }
        return null;
    }
}