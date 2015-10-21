/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    List<Integer> list = new ArrayList<Integer>();
    int pos = 0;
    
    public BSTIterator(TreeNode root) {
        list = buildList(root);
    }
    
    private List<Integer> buildList(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        List<Integer> leftlist = buildList(root.left);
        List<Integer> rightlist = buildList(root.right);
        if (leftlist != null) res.addAll(leftlist);
        res.add(root.val);
        if (rightlist != null) res.addAll(rightlist);
        System.out.println(res);
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return pos < list.size();
    }

    /** @return the next smallest number */
    public int next() {
        ++pos;
        return list.get(pos - 1);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */