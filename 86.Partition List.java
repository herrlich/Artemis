/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode p1 = res, p2 = head;
        while (p1.next != null && p1.next.val < x) p1 = p1.next;
        p2 = p1;
        if (p2 == null) return res.next;
        while (p2.next != null) {
            if (p2.next.val >= x) p2 = p2.next;
            else {
                ListNode tmp = p1.next;
                p1.next = p2.next;
                p2.next = p2.next.next;
                p1 = p1.next;
                p1.next = tmp;
            }
        }
        return res.next;
    }
}