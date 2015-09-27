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
        if (n == 0) {
            res.add(null);
            return res;
        }
        TreeNode tmp = null;
        res = getBinary(1, n);
        return res;
    }
    
    public List<TreeNode> getBinary(int start, int end) {
        if (start > end) return null;
        List<TreeNode> tmp = new ArrayList<TreeNode>();
        for (int k = start; k <= end; ++k) {
            List<TreeNode> leftlist = getBinary(start, k - 1);
            List<TreeNode> rightlist = getBinary(k + 1, end);
            if (leftlist == null || rightlist == null) {
                if (leftlist == null && rightlist == null) {
                    TreeNode cur = new TreeNode(k);
                    tmp.add(cur);
                    continue;
                }
                if (leftlist == null) {
                    for (int i = 0; i < rightlist.size(); ++i) {
                        TreeNode cur = new TreeNode(k);
                        cur.right = rightlist.get(i);
                        cur.left = null;
                        tmp.add(cur);
                    }
                    continue;
                }
                if (rightlist == null) {
                    for (int i = 0; i < leftlist.size(); ++i) {
                        TreeNode cur = new TreeNode(k);
                        cur.right = null;
                        cur.left = leftlist.get(i);
                        tmp.add(cur);
                    }
                    continue;
                }
            }
            for (int i = 0 ; i < leftlist.size(); ++i) {
                for (int j = 0; j < rightlist.size(); ++j) {
                    TreeNode cur = new TreeNode(k);
                    cur.left = leftlist.get(i);
                    cur.right = rightlist.get(j);
                    tmp.add(cur);
                }
            }
        }
        return tmp;
    }
}