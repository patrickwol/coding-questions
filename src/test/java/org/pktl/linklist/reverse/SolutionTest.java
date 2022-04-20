package org.pktl.linklist.reverse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.pktl.common.ListNode;
import org.pktl.util.LinkListUtil;

class SolutionTest {

    @Test
    void reverseList() {
        ListNode l1 = null;
        System.out.println(new Solution().ReverseList(l1));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/linklist-reverse.csv")
    void reverseListCsv(String s, String res) {
        final ListNode listNode = LinkListUtil.stringToLinkList(s);
        System.out.printf("input :%s\n", listNode);
        final ListNode expectListNode = LinkListUtil.stringToLinkList(res);
        System.out.printf("expect:%s\n", expectListNode);
        final ListNode resListNode = new Solution().ReverseList(listNode);
        System.out.printf("result:%s\n", resListNode);
    }

}