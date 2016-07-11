/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode tmp1 = headA, tmp2 = headB;
        while (tmp1 != null && tmp2 != null) {
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        if (tmp1 == null) tmp1 = headB;
        if (tmp2 == null) tmp2 = headA;
        while (tmp1 != null && tmp2 != null) {
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        if (tmp1 == null) tmp1 = headB;
        if (tmp2 == null) tmp2 = headA;
        while (tmp1 != null) {
            if (tmp1 == tmp2) return tmp1;
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        return null;
    }
}

------------------------------------------------------------
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = 1, lenB = 1;
        ListNode tmp1 = headA;
        while (tmp1.next != null) {
            ++lenA;
            tmp1 = tmp1.next;
        }
        ListNode tmp2 = headB;
        while (tmp2.next != null) {
            ++lenB;
            tmp2 = tmp2.next;
        }
        if (tmp1 != tmp2) return null;
        if (lenA >= lenB) {
            tmp1 = headA;
            tmp2 = headB;
        }
        else {
            tmp1 = headB;
            tmp2 = headA;
        }
        for (int i = 0; i < Math.abs(lenA - lenB); ++i) tmp1 = tmp1.next;
        for (int i = 0; i < Math.min(lenA, lenB); ++i) {
            if (tmp1 == tmp2) return tmp1;
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        return null;
    }
}