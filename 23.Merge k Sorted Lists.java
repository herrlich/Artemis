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
        ListNode head = new ListNode(-1);
        ListNode p = head;
        if (lists == null || lists.length == 0) return null;
        int num = lists.length;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(num, new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;}
        });
        for (int i = 0; i < num; ++i) {
            if (lists[i] != null) queue.offer(lists[i]);
        }
        while (!queue.isEmpty()) {
            ListNode tmp = queue.poll();
            p.next = tmp;
            p = p.next;
            if (tmp.next != null) queue.offer(tmp.next);
        }
        return head.next;
    }
}


//The "wrong" method.
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