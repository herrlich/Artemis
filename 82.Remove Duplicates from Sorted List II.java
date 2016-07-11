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
        if (head == null || head.next == null) return head;
        ListNode res = new ListNode(-1);
        ListNode p1 = res, p2 = head;
        res.next = head;
        while (p2.next != null) {
            if (p2.val == p2.next.val) {
                int tmp = p2.val;
                while (p2 != null) {
                    if (p2.val == tmp) p2 = p2.next;
                    else break;
                }
                p1.next = p2;
                if (p2 == null) break;
            }
            else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return res.next;
    }
}