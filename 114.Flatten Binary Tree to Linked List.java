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
	public static void flatten(TreeNode root) {
		while (root != null) {
			if (root.left != null) {
				TreeNode tmp = root.left;
				while (tmp.right != null) tmp = tmp.right;
				tmp.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			root = root.right;
		}
    }
}

//recursion
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
    public void flatten(TreeNode root) {
        if (root == null) return;
        getFlat(root);
    }
    
    public TreeNode getFlat(TreeNode root) {
        if (root == null) return null;
        TreeNode left = getFlat(root.left);
        TreeNode right = getFlat(root.right);
        root.left = null;
        root.right = left;
        TreeNode tmp = root;
        while (tmp.right != null) tmp = tmp.right;
        tmp.right = right;
        return root;
    }
}