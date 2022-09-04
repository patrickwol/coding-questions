package org.pktl.linklist.kth_to_tail;

import org.junit.jupiter.api.Test;
import org.pktl.util.ListNode;

class SolutionTest {

    @Test
    void findKthToTail() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = l1.next = new ListNode(2);
        ListNode l3 = l2.next = new ListNode(3);
        ListNode l4 = l3.next = new ListNode(4);
        final ListNode listNode = new Solution().FindKthToTail(l1, 5);
        System.out.println(listNode == null ? "" : listNode.val);
    }
}