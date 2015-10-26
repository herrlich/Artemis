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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode leftres = lowestCommonAncestor(root.left, p, q);
        TreeNode rightres = lowestCommonAncestor(root.right, p, q);
        if (leftres != null && rightres != null) return root;
        else {
            if (leftres != null) return leftres;
            else {
                if (rightres != null) return rightres;
                return null;
            }
        }
    }
}