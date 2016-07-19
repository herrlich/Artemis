/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode l1 = head, l2 = head, tmp = null;
        while (l2 != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next.next;
        }
        while (l1 != null) {
            l2 = l1.next;
            l1.next = tmp;
            tmp = l1;
            l1 = l2;
        }
        while (tmp != null && head != tmp) {
            if (tmp.val != head.val) return false;
            tmp = tmp.next;
            head = head.next;
        }
        return true;
    }
}