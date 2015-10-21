/*
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target. 

Note:

1.Given target value is a floating point.
2.You are guaranteed to have only one unique value in the BST that is closest to the target.
*/

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
    public int closestValue(TreeNode root, double target) {
        int tmp;
        double dif = Math.abs(root.val - target);
        if (target > root.val) {
            if (root.right == null) return root.val;
            tmp = closestValue(root.right, target);
        }
        else {
            if (root.left == null) return root.val;
            tmp = closestValue(root.left, target);
        }
        if (Math.abs(tmp - target) > dif) return root.val;
        else return tmp;
    }
}