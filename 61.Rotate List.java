/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode p1 = head, p2 = head, res = null;
        int count = 0;
        while (p1 != null) {
            p1 = p1.next;
            ++count;
        }
        p1 = head;
        if (k % count == 0) return head;
        for (int i = 0; i < k % count; ++i) p2 = p2.next;
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        res = p1.next;
        p1.next = null;
        p2.next = head;
        return res;
    }
}