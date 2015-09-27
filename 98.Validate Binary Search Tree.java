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
        else return checkBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
	
	public boolean checkBST(TreeNode head, double min, double max) {
		if (head == null) return true;
		if (head.val >= max || head.val <= min) return false;
		return checkBST(head.left, min, head.val) && checkBST(head.right, head.val, max);
	}
}