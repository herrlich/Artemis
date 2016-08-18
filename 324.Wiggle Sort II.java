//Reference:
//https://discuss.leetcode.com/topic/32929/o-n-o-1-after-median-virtual-indexing
//https://discuss.leetcode.com/topic/41464/step-by-step-explanation-of-index-mapping-in-java

public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int median = quickSelect(nums, 0, nums.length, (nums.length - 1) / 2);
        int n = nums.length;
        int left = 0, i = 0, right = n - 1;
        while (i <= right) {
            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else ++i;
        }
    }

    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }
    
    private void swap(int[] array, int p1, int p2) {
        int tmp = array[p1];
        array[p1] = array[p2];
        array[p2] = tmp;
    }
    
    public int quickSelect(int[] array, int start, int end, int k) {
        int mid = (start + end) / 2;
        int num = array[mid];
        array[mid] = array[start];
        array[start] = num;
        int cur = start;
        for (int i = start + 1; i < end; ++i) {
            if (array[i] < num) {
                int tmp = array[i];
                array[i] = array[cur + 1];
                array[cur + 1] = array[cur];
                array[cur] = tmp;
                ++cur;
            }
        }
        if (cur - start == k) return num;
        if (cur - start > k) return quickSelect(array, start, cur, k);
        else return quickSelect(array, cur + 1, end, k - (cur - start) - 1);
    }
}