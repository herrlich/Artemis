public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums.length < 4) return list;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    if (left > j + 1 && nums[left - 1] == nums[left]) {
                        ++left;
                        continue;
                    }
                    int tmpsum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (tmpsum == target) {
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(nums[i]); tmp.add(nums[j]);
                        tmp.add(nums[left]); tmp.add(nums[right]);
                        list.add(tmp);
                        ++left; --right;
                        continue;
                    }
                    if (tmpsum > target) --right;
                    else ++left;
                }
            }
        }
        return list;
    }
}

//我用hashmap做出的方法
class Pair{
    public int x1;
    public int x2;
    public Pair(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) return list;
        Arrays.sort(nums);
        HashMap<Integer, List<Pair>> map = new HashMap<Integer, List<Pair>>();
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int tmp = nums[i] + nums[j];
                Pair p = new Pair(i, j);
                if (map.containsKey(tmp)) {
                    map.get(tmp).add(p);
                }
                else {
                    List<Pair> l = new ArrayList<Pair>();
                    l.add(p);
                    map.put(tmp, l);
                }
            }
        }
        for (int k : map.keySet()) {
            int n = target - k;
            if (n < k) continue;
            if (map.containsKey(n)) {
                List<Pair> l1 = map.get(k);
                List<Pair> l2 = map.get(n);
                for (int i = 0; i < l1.size(); ++i) {
                    for (int j = 0; j < l2.size(); ++j) {
                        if (l1.get(i).x2 < l2.get(j).x1) {
                            List<Integer> ltmp = new ArrayList<Integer>();
                            ltmp.add(nums[l1.get(i).x1]); ltmp.add(nums[l1.get(i).x2]);
                            ltmp.add(nums[l2.get(j).x1]); ltmp.add(nums[l2.get(j).x2]);
                            list.add(ltmp);
                        } 
                    }
                }
            }
        }
        HashSet set = new HashSet(list);//重点是这里的HashSet初始化
        list.clear();
        list.addAll(set);
        return list;
    }
}