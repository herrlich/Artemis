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
        if (root == null) return list;
        getPath(root, sum, list, new ArrayList<Integer>());
        return list;
    }
    
    private void getPath(TreeNode root, int sum, List<List<Integer>> res, List<Integer> tmp) {
        if (root == null) return;
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> cur = new ArrayList<Integer>();
            for (int i = 0; i < tmp.size(); ++i) cur.add(tmp.get(i));
            cur.add(root.val);
            res.add(cur);
            return;
        }
        tmp.add(root.val);
        getPath(root.left, sum - root.val, res, tmp);
        getPath(root.right, sum - root.val, res, tmp);
        tmp.remove(tmp.size() - 1);
    }
}