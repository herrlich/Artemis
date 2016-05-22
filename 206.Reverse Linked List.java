/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode prev = null;
        ListNode tmp = head;
        while (head != null) {
            tmp = head;
            head = head.next;
            tmp.next = prev;
            prev = tmp;
        }
        return tmp;
    }
}

-----------------------------------------------------------------------
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode nextnode = head.next;
        head.next = null;
        ListNode res = reverseList(nextnode);
        nextnode.next = head;
        return res;
    }
}