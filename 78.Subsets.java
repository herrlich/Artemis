public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return list;
        Arrays.sort(nums);
        List<Integer> initial = new ArrayList<Integer>();
        list.add(initial);
        for (int i = 0; i < nums.length; ++i) {
            int len = list.size();
            for (int j = 0; j < len; ++j) {
                List<Integer> tmp = new ArrayList<Integer>();
                for (int k = 0; k < list.get(j).size(); ++k) tmp.add(list.get(j).get(k));
                tmp.add(nums[i]);
                list.add(tmp);
            }
        }
        return list;
    }
}

//Another method
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return list;
        Arrays.sort(nums);
        list.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; ++i) {
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            for (List<Integer> l : list) {
                List<Integer> cur = new ArrayList<Integer>(l);
                cur.add(nums[i]);
                tmp.add(cur);
            }
            list.addAll(tmp);
        }
        return list;
    }
}