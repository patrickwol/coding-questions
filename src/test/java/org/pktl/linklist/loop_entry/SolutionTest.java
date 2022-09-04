package org.pktl.linklist.loop_entry;

import org.junit.jupiter.api.Test;
import org.pktl.util.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void entryNodeOfLoop() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = l1.next = new ListNode(2);
        ListNode l3 = l2.next = new ListNode(3);
        l3.next=l1;
        final ListNode listNode = new Solution().EntryNodeOfLoop(l1);
        assertEquals(listNode, l1);
    }
}