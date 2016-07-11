public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length == 0 || k <= 0) return list;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Comparator<Integer> cmp = new Comparator<Integer>() {
            public int compare(Integer e1, Integer e2) {
                return map.get(e2) - map.get(e1);
            }
        };
        Queue<Integer> pq = new PriorityQueue<Integer>(nums.length, cmp);
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);
        }
        for (int i : map.keySet()) pq.offer(i);
        for (int i = 0; i < k; ++i) list.add(pq.poll());
        return list;
    }
}