package org.pktl.linklist.hascycle;

import org.junit.jupiter.api.Test;
import org.pktl.common.ListNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void hasCycle() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = l1.next = new ListNode(2);
        ListNode l3 = l2.next = new ListNode(3);
        l3.next=l1;
        assertTrue(solution.hasCycle(l1));
    }

    @Test
    void hasCycleNoCycle() {
        final ListNode l1 = new ListNode(1);
        ListNode l2 = l1.next = new ListNode(2);
        ListNode l3 = l2.next = new ListNode(2);
        ListNode l4 = l3.next = new ListNode(2);
        assertFalse(solution.hasCycle(l1));
    }

    @Test
    void hasCycleSingleNode() {
        final ListNode l1 = new ListNode(1);
        assertFalse(solution.hasCycle(l1));
    }

    @Test
    void hasCycleNullNode() {
        final ListNode l1 = null;
        assertFalse(solution.hasCycle(l1));
    }


}