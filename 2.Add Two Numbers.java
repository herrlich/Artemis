/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        res.next = null;
        ListNode tmp = res;
        int carry = 0;
        if (l1 == null || l2 == null) {
            if (l1 == null) return l2;
            else return l1;
        }
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
        }
        if (carry == 1) {
            tmp.next = new ListNode(1);
            tmp = tmp.next;
        }
        tmp.next = null;
        return res.next;
    }
}