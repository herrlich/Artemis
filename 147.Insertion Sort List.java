/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode res = head, tmp = null;
        head = head.next;
        res.next= null;
        while (head != null) {
            if (res.val >= head.val) {
                tmp = head.next;
                head.next = res;
                res = head;
                head = tmp;
                continue;
            }
            tmp = res;
            while (tmp.next != null) {
                if (tmp.next.val >= head.val) {
                    ListNode n = head.next;
                    head.next = tmp.next;
                    tmp.next = head;
                    head = n;
                    break;
                }
                else tmp = tmp.next;
            }
            if (tmp.next == null) {
                tmp.next = head;
                head = head.next;
                tmp.next.next = null;
            }
        }
        return res;
    }
}