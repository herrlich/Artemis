/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        RandomListNode res = new RandomListNode(-1);
        res.next = head;
        RandomListNode tmp = null;
        RandomListNode cur = head;
        while (cur != null) {
            tmp = cur.next;
            RandomListNode newnode = new RandomListNode(cur.label);
            cur.next = newnode;
            newnode.next = tmp;
            cur = tmp;
        }
        cur = head;
        while (cur != null) {
            if (cur.random == null) cur.next.random = null;
            else cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        
        cur = head;
        tmp = res;
        while (cur != null) {
            tmp.next = cur.next;
            tmp = tmp.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return res.next;
    }
}