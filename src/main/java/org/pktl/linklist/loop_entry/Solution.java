package org.pktl.linklist.loop_entry;

import org.pktl.util.ListNode;

/**
 * 牛客 BM7 链表中环的入口结点
 */
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode l1 = pHead;
        ListNode l2 = pHead;
        boolean hasCycle = false;
        while (l2 != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next.next;
            if (l1 == l2) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return null;
        }
        ListNode t1 = pHead;
        while (t1 != null && l1 != null) {
            if (t1 == l1) {
                return t1;
            }
            t1 = t1.next;
            l1 = l1.next;
        }
        return null;
    }
}
