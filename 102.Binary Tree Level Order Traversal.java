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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        List<TreeNode> queue1 = new ArrayList<TreeNode>();
        List<TreeNode> queue2 = new ArrayList<TreeNode>();
        queue1.add(root);
        while (!queue1.isEmpty()) {
            List<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < queue1.size(); ++i) {
                TreeNode node = queue1.get(i);
                tmp.add(node.val);
                if (node.left != null) queue2.add(node.left);
                if (node.right != null) queue2.add(node.right);
            }
            res.add(tmp);
            queue1 = queue2;
            queue2 = new ArrayList<TreeNode>();
        }
        return res;
    }
}



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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<Integer>();
            int len = queue.size();
            for (int i = 0; i < len; ++i) {
                TreeNode node = queue.removeFirst();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}