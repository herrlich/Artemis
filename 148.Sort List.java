/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head, p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        p2 = p1.next;
        p1.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(p2);
        return MergeSort(left, right);
    }
    
    public ListNode MergeSort(ListNode left, ListNode right) {
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tmp.next = left;
                left = left.next;
            }
            else {
                tmp.next = right;
                right = right.next;
            }
            tmp = tmp.next;
        }
        if (left != null) tmp.next = left;
        else tmp.next = right;
        return res.next;
    }
}