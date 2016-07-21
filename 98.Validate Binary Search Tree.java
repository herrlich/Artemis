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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        else return checkValid(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
	
	public boolean checkValid(TreeNode root, double low, double high) {
        if (root == null) return true;
        if (root.val <= low || root.val >= high) return false;
        return checkValid(root.left, low, root.val) && checkValid(root.right, root.val, high);
    }
}