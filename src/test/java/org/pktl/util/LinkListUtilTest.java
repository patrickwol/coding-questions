package org.pktl.util;

import org.junit.jupiter.api.Test;

class LinkListUtilTest {

    @Test
    void stringToLinkList() {
        String s = "1 2 3 4";
        final ListNode listNode = LinkListUtil.stringToLinkList(s);
        System.out.println(listNode);
    }

    @Test
    void linkListToString() {
        final ListNode l1 = new ListNode(1);
        final ListNode l2 = l1.next = new ListNode(2);
        final ListNode l3 = l2.next = new ListNode(3);
        System.out.println(LinkListUtil.linkListToString(l1));
    }

    @Test
    void compareLinkList() {
        final ListNode l1 = new ListNode(1);
        final ListNode l2 = l1.next = new ListNode(2);
        final ListNode l3 = l2.next = new ListNode(3);
        final ListNode l4 = l3.next = new ListNode(3);
        final ListNode t1 = new ListNode(1);
        final ListNode t2 = t1.next = new ListNode(2);
        final ListNode t3 = t2.next = new ListNode(3);
        System.out.println(LinkListUtil.compareLinkList(t1, l1));
    }
}