/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            }
            else {
                tmp.next = l2;
                l2  = l2.next;
            }
            tmp = tmp.next;
        }
        if (l1 != null) tmp.next = l1;
        else tmp.next = l2;
        return head.next;
    }
}