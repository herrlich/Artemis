/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            root.next = null;
            return;
        }
        TreeLinkNode prev = root, cur, tmp1, tmp2;
        TreeLinkNode start = null;
        if (root.left != null) cur = root.left;
        else cur = root.right;
        while (cur != null) {
            tmp1 = cur;
            tmp2 = null;
            start = null;
            while (prev != null) {
                if (start == null) {
                    if (tmp1.left != null) start = tmp1.left;
                    else{
                        if (tmp1.right != null) start = tmp1.right;
                    }
                }
                while (prev != null) {
                    if (prev.left != null && prev.left != tmp1 && prev.right != tmp1) {
                        tmp2 = prev.left;
                        break;
                    }
                    if (prev.right != null && prev.right != tmp1) {
                        tmp2 = prev.right;
                        break;
                    }
                    prev = prev.next;
                }
                tmp1.next = tmp2;
                tmp1 = tmp1.next;
                tmp2 = null;
            }
            prev = cur;
            cur = start;
        }
    }
}