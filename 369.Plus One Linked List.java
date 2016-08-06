Given a non-negative number represented as a singly linked list of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Example:

Input:
1->2->3

Output:
1->2->4


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null) return head;
        int num = plusList(head);
        if (num == 1) {
            ListNode res = new ListNode(1);
            res.next = head;
            return res;
        }
        return head;
    }
    
    public int plusList(ListNode head) {
        if (head == null) return 1;
        int num = plusList(head.next);
        int res = (head.val + num) / 10;
        head.val = (head.val + num) % 10;
        return res;
    }
}