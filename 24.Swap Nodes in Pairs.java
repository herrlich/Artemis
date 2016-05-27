/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head, p2 = head.next;
        p1.next = swapPairs(p2.next);
        p2.next = p1;
        return p2;
    }
}

-------------------------------------------------------------------------
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res, p1 = null, p2 = null;
        while (pre.next != null && pre.next.next != null) {
            p2 = pre.next.next;
            p1 = pre.next;
            p1.next = p2.next;
            p2.next = p1;
            pre.next = p2;
            pre = p1;
        }
        return res.next;
    }
}