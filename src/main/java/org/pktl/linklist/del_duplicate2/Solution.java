package org.pktl.linklist.del_duplicate2;

import org.pktl.util.ListNode;

/**
 * 牛客 BM16 删除有序链表中重复的元素-II
 */
public class Solution {

    public ListNode deleteDuplicates (ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = new ListNode(-1);
        ListNode pHead = p;
        p.next = head;
        ListNode c = head;
        ListNode n = head.next;
        while (c != null && n != null) {
            if (c.val != n.val) {
                n = n.next;
                c = c.next;
                p = p.next;
            } else {
                while (n != null && c.val == n.val) {
                    n = n.next;
                }
                c = n;
                if (n != null) {
                    n = n.next;
                }
                p.next = c;
            }
        }
        return pHead.next;
    }
}
