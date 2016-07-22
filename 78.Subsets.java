public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return list;
        list.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; ++i) {
            int listlen = list.size();
            for (int j = 0; j < listlen; ++j) {
                List<Integer> tmp = new ArrayList<Integer>(list.get(j));
                tmp.add(nums[i]);
                list.add(tmp);
            }
        }
        return list;
    }
}

//Another method using Bit manipulation
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return list;
        int count = (int)Math.pow(2, nums.length);
        for (int i = 0; i < count; ++i) {
            List<Integer> tmp = new ArrayList<Integer>();
            int flag = i;
            for (int j = 0; j < nums.length; ++j) {
                if ((flag & 1) == 1) tmp.add(nums[nums.length - 1 - j]);
                flag >>= 1;
            }
            list.add(tmp);
        }
        return list;
    }
}


//Another method (in fact the same with the first one)
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