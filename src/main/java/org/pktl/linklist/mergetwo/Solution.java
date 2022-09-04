package org.pktl.linklist.mergetwo;

import org.pktl.util.ListNode;

/**
 * 牛客 BM4 合并两个排序的链表
 */
public class Solution {

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode h = new ListNode(0);
        ListNode c = h;
        ListNode t1 = list1;
        ListNode t2 = list2;
        while (t1 != null && t2 != null) {
            if (t1.val <= t2.val) {
                c.next = t1;
                t1 = t1.next;
            } else {
                c.next = t2;
                t2 = t2.next;
            }
            c=c.next;
        }
        if (t1 != null) {
            c.next = t1;
        }
        if (t2 != null) {
            c.next = t2;
        }
        return h.next;
    }
}
