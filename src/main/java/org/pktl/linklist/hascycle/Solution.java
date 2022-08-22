package org.pktl.linklist.hascycle;

import org.pktl.util.ListNode;

/**
 * 牛客 BM6 判断链表中是否有环
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode l1 = head;
        ListNode l2 = head;
        while (l2 != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next.next;
            if (l1 == l2) {
                return true;
            }
        }
        return false;
    }
}
