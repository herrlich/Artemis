public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) return list;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] > 0) break;
            int p1 = i + 1;
            int p2 = nums.length - 1;
            while (p1 < p2) {
                if (nums[p1] + nums[i] > 0) break;
                if (nums[i] + nums[p1] + nums[p2] == 0) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]); tmp.add(nums[p1]); tmp.add(nums[p2]);
                    list.add(tmp);
                    ++p1; --p2;
                    while (p1 < p2 && nums[p1] == nums[p1 - 1]) ++p1;
                    continue;
                }
                if (nums[i] + nums[p1] + nums[p2] > 0) --p2;
                else ++p1;
            }
        }
        return list;
    }
}
