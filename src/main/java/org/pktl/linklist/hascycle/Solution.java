package org.pktl.linklist.hascycle;

import org.pktl.common.ListNode;

public class Solution {

    public boolean hasCycle(ListNode head) {
/*        if (head == null) {
            return false;
        }*/
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
