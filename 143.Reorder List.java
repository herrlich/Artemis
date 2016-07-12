/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode n1 = head, n2 = head, prev = null;
        ListNode res = new ListNode(-1);
        while (n2 != null && n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        while (n1 != null) {
            n2 = n1.next;
            n1.next = prev;
            prev = n1;
            n1 = n2;
        }
        n1 = head;
        n2 = res;
        while (prev != null && n1 != prev) {
            n2.next = n1;
            n1 = n1.next;
            n2.next.next = prev;
            prev = prev.next;
            n2 = n2.next.next;
        }
        if (n1 == prev) n2.next = prev;
    }
}