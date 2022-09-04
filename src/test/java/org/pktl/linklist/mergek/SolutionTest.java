package org.pktl.linklist.mergek;

import cn.hutool.core.collection.ListUtil;
import org.junit.jupiter.api.Test;
import org.pktl.util.LinkListUtil;
import org.pktl.util.ListNode;

import java.util.ArrayList;

class SolutionTest {

    @Test
    void mergeKLists() {
        final ListNode l0 = LinkListUtil.stringToLinkList("1 2");
        final ListNode l1 = LinkListUtil.stringToLinkList("1 4 5");
        final ListNode l2 = LinkListUtil.stringToLinkList("3 6 7");
        final ArrayList<ListNode> listNodes = ListUtil.toList(l0, l1, l2);
        final ListNode listNode = new Solution().mergeKLists(listNodes);
        System.out.println(LinkListUtil.linkListToString(listNode));
    }

}