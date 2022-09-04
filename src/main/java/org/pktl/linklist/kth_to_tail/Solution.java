package org.pktl.linklist.kth_to_tail;

import org.pktl.util.ListNode;

/**
 * 牛客 BM8 链表中倒数最后k个结点
 */
public class Solution {

    public ListNode FindKthToTail (ListNode pHead, int k) {
        ListNode l1 = pHead;
        for (int i = 0; i < k; i++) {
            if (l1 == null) {
                return null;
            }
            l1 = l1.next;
        }
        ListNode l2 = pHead;
        while (l1 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l2;
    }
}
