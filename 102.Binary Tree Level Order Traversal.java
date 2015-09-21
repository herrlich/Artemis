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




//Another Method
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
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) return list;
        List<TreeNode> s = new LinkedList<TreeNode>();//If we use an ArrayList here, the following remove() operation will take a lot of time.
        s.add(root);
        
        while (!s.isEmpty()) {
        	int len = s.size();
        	List<Integer> level = new ArrayList<Integer>();
        	for (int i = 0; i < len; ++i) {
        		TreeNode tmp = s.remove(0);
        		level.add(tmp.val);
        		if (tmp.left != null) s.add(tmp.left);
        		if (tmp.right != null) s.add(tmp.right);
        	}
        	list.add(level);
        }
        return list;
    }
}