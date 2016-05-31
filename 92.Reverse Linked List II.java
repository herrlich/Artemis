/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return head;
        
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode p1 = res, p2 = res, post = null;
        for (int i = 0; i < m - 1; ++i) p1 = p1.next;
        for (int i = 0; i < n; ++i) p2 = p2.next;
        post = p2.next;
        
        ListNode pre = p1.next;
        ListNode t1 = null, t2 = t1, tmp = p1.next;
        while (tmp != post) {
            t2 = tmp.next;
            tmp.next = t1;
            t1 = tmp;
            tmp = t2;
        }
        
        p1.next = t1;
        pre.next = post;
        return res.next;
    }
}