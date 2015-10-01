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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
    	if (root == null || root.left == null) return root;
        TreeNode last = root;
        TreeNode leftsub = null; //to store the left subtree of the current node
        TreeNode lastright = root.right; // to store the right node of the parent node
        TreeNode tmp = root.left; //tmp is the current node we are exploring
        root.left = null; root.right = null; //without this, we will get memory limit exceeded since there will be a cycle
        while (tmp != null) {
        	leftsub = tmp.left;
        	tmp.left = lastright;
        	lastright = tmp.right;
        	tmp.right = last;
        	last = tmp;
        	tmp = leftsub;
        }
        return last;
	}
}