/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) head = head.next;
        if (head == null) return null;
        ListNode res = head;
        ListNode tmp = head.next;
        while (tmp != null) {
            if (tmp.val == val) {
                tmp = tmp.next;
                res.next = tmp;
            }
            else {
                res = tmp;
                tmp = tmp.next;
            }
        }
        return head;
    }
}