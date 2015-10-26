/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode res = merge(lists, 0, lists.length - 1);
        return res;
    }
    
    public ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        int mid = start + (end - start) / 2;
        ListNode left = merge(lists, start, mid);
        ListNode right = merge(lists, mid + 1, end);
        return mergeSort(left, right);
    }
    
    public ListNode mergeSort(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode tmp = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
                tmp = tmp.next;
            }
            else {
                tmp.next = l2;
                l2 = l2.next;
                tmp = tmp.next;
            }
        }
        if (l1 != null) tmp.next = l1;
        if (l2 != null) tmp.next = l2;
        return res.next;
    }
}