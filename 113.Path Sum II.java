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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        getPath(root, sum, tmp, list);
        return list;
    }
    
    public void getPath(TreeNode root, int sum, List<Integer> tmp, List<List<Integer>> list) {
        if (root == null) return;
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> newlist = new ArrayList<Integer>(tmp);
            newlist.add(root.val);
            list.add(newlist);
            return;
        }
        tmp.add(root.val);
        getPath(root.left, sum - root.val, tmp, list);
        getPath(root.right, sum - root.val, tmp, list);
        tmp.remove(tmp.size() - 1);
    }
}