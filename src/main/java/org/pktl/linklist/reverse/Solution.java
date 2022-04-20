package org.pktl.linklist.reverse;

import org.pktl.common.ListNode;

/**
 * 牛客
 * BM1 反转链表
 */
public class Solution {

    public ListNode ReverseList(ListNode head) {
        ListNode p = null, c = head, t = null;
        while (c != null) {
            t = c.next;
            c.next = p;
            p = c;
            c = t;
        }
        return p;
    }
}
