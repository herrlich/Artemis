/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 //seems that the original array cannot be modified.
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        RandomListNode tmp = head;
        RandomListNode cur = null;
        while (tmp != null) {
            RandomListNode n = new RandomListNode(tmp.label);
            cur = tmp.next;
            tmp.next = n;
            n.next = cur;
            tmp = cur;
        }
        tmp = head;
        while (tmp != null) {
            if (tmp.random == null) tmp.next.random = null;
            else tmp.next.random = tmp.random.next;
            tmp = tmp.next.next;
        }
        RandomListNode res = head.next;
        tmp = head.next;
        while (tmp.next != null) {
            cur = tmp.next;
            tmp.next = tmp.next.next;
            tmp = tmp.next;
            head.next = cur;
            head = head.next;
        }
        head.next = null;
        return res;
    }
}