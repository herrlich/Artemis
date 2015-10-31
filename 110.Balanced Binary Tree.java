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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return (check(root) != -1);
    }
    
    private int check(TreeNode root) {
        if (root == null) return 0;
        int left = check(root.left);
        int right = check(root.right);
        if (left == -1 || right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}


//Another method
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
    public static HashMap<TreeNode, Integer> depth = new HashMap<TreeNode, Integer>();
    public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			depth.put(null, 0);
			return true;
		}
		if (isBalanced(root.left) && isBalanced(root.right)) {
			int left = depth.get(root.left);
			int right = depth.get(root.right);
			depth.put(root, Math.max(left, right) + 1);
			if (Math.abs(left - right) <= 1) return true;
			else return false;
		}
		else return false;
    }
}