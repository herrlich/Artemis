/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode l1 = head, l2 = null;
        while (l1.next != null) {
            l2 = l1.next;
            if (l1.val == l2.val) l1.next = l2.next;
            else l1 = l1.next;
        }
        return head;
    }
}