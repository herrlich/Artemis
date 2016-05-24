/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return getBST(nums, 0, nums.length - 1);
    }
    
    public TreeNode getBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode res = new TreeNode(nums[mid]);
        res.left = getBST(nums, start, mid - 1);
        res.right = getBST(nums, mid + 1, end);
        return res;
    }
}