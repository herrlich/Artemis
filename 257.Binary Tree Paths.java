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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        if (root == null) return list;
        getPath(root, list, "");
        return list;
    }
    
    public void getPath(TreeNode t, List<String> list, String cur) {
        if (t.left == null && t.right == null) {
            list.add(cur + t.val);
            return;
        }
        if (t.left != null) getPath(t.left, list, cur + t.val + "->");
        if (t.right != null) getPath(t.right, list, cur + t.val + "->");
    }
}