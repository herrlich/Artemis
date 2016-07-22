public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return list;
        list.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        List<List<Integer>> prev = null;
        List<List<Integer>> pointer = null;
        for (int i = 0; i < nums.length; ++i) {
            if (prev == null || nums[i] != nums[i - 1]) {
                pointer = list;
                prev = new ArrayList<List<Integer>>();
                getElements(pointer, prev, list, nums[i]);
            }
            else {
                pointer = prev;
                prev = new ArrayList<List<Integer>>();
                getElements(pointer, prev, list, nums[i]);
            }
        }
        return list;
    }
    
    public void getElements(List<List<Integer>> target, List<List<Integer>> prev, List<List<Integer>> list, int num) {
        for (List<Integer> li : target) {
            List<Integer> tmp = new ArrayList<Integer>(li); // this method is useful to copy
            tmp.add(num);
            prev.add(tmp);
        }
        list.addAll(prev); // addAll to avoid concurrent problems
    }
}