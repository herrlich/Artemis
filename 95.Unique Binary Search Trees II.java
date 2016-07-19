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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (n < 1) return res;
        res = parseTrees(1, n);
        return res;
    }
    
    public List<TreeNode> parseTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (start > end)  {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; ++i) {
            List<TreeNode> leftlist = parseTrees(start, i - 1);
            List<TreeNode> rightlist = parseTrees(i + 1, end);
            for (int m = 0; m < leftlist.size(); ++m) {
                for (int n = 0; n < rightlist.size(); ++n) {
                    TreeNode tmp = new TreeNode(i);
                    tmp.left = leftlist.get(m);
                    tmp.right = rightlist.get(n);
                    list.add(tmp);
                }
            }
        }
        return list;
    }
}