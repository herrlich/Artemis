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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        boolean reverse = false;
        while (list.size() != 0) {
            int len = list.size();
            List<Integer> tmp = new ArrayList<Integer>();
            if (!reverse) {
                for (int i = 0; i < len; ++i) {
                    TreeNode t = list.removeFirst();
                    if (t.left != null) list.add(t.left);
                    if (t.right != null) list.add(t.right);
                    tmp.add(t.val);
                }
                reverse = true;
            }
            else {
                for (int i = 0; i < len; ++i) {
                    TreeNode t = list.removeFirst();
                    if (t.left != null) list.add(t.left);
                    if (t.right != null) list.add(t.right);
                    stack.push(t);
                }
                while (!stack.isEmpty()) {
                    TreeNode t = stack.pop();
                    tmp.add(t.val);
                }
                reverse = false;
            }
            res.add(tmp);
        }
        return res;
    }
}


-----------------------------------------------------------------------------------
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.add(root);
        int count = 0;
        while (!queue1.isEmpty()) {
            List<Integer> tmp = new ArrayList<Integer>();
            if (count % 2 == 0) {
                for (int i = 0; i < queue1.size(); ++i) {
                    TreeNode cur = queue1.get(i);
                    tmp.add(cur.val);
                    if (cur.left != null) queue2.addFirst(cur.left);
                    if (cur.right != null) queue2.addFirst(cur.right);
                }
            }
            else {
                for (int i = 0; i < queue1.size(); ++i) {
                    TreeNode cur = queue1.get(i);
                    tmp.add(cur.val);
                    if (cur.right != null) queue2.addFirst(cur.right);
                    if (cur.left != null) queue2.addFirst(cur.left);
                }
            }
            ++count;
            queue1 = queue2;
            queue2 = new LinkedList<TreeNode>();
            res.add(tmp);
        }
        return res;
    }
}