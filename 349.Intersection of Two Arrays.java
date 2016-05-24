public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> arr1 = new HashSet<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        for (int i = 0; i < nums1.length; ++i) arr1.add(nums1[i]);
        for (int i = 0; i < nums2.length; ++i) {
            if (arr1.contains(nums2[i])) set.add(nums2[i]);
        }
        int[] res = new int[set.size()];
        int count = 0;
        for (int i : set) res[count++] = i;
        return res;
    }
}