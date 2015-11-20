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
        TreeLinkNode last = root, cur = root.left;
        TreeLinkNode tmp = cur;
        while (cur != null) {
            tmp = cur;
            while (last != null) {
                if (tmp == last.left) {
                    tmp.next = last.right;
                    tmp = tmp.next;
                    last = last.next;
                }
                else {
                    tmp.next = last.left;
                    tmp = tmp.next;
                }
            }
            last = cur;
            cur = last.left;
        }
    }
}