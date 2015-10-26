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
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode cur = null;
    
    public BSTIterator(TreeNode root) {
        //或者直接写cur = root,然后在next函数中进行压栈
        TreeNode tmp = root;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.left;
        }
        cur = null;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!stack.isEmpty() || (cur != null));
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmp = null;
        if (cur == null) {
            tmp = stack.pop();
            cur = tmp.right;
        }
        else {
            while (cur.left != null) {
                stack.push(cur);
                cur = cur.left;
            }
            tmp = cur;
            cur = cur.right;
        }
        return tmp.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */