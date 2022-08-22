package org.pktl.linklist.reversebetween;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.pktl.linklist.LinkListConverter;
import org.pktl.util.ListNode;
import org.pktl.util.LinkListUtil;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "1 2 3 4 5,2,4,1 4 3 2 5",
            "1 2 3 4 5,4,4,1 2 3 4 5",
            "1 2 3 4 5,1,4,4 3 2 1 5",
            "1 2 3 4 5,1,5,5 4 3 2 1",
            "5,1,1,5",
            "1 2 3 4 5,2,5,1 5 4 3 2"
    })
    void reverseBetween(@ConvertWith(LinkListConverter.class) ListNode input, int m, int n, @ConvertWith(LinkListConverter.class) ListNode expect) {
        System.out.printf("input :%s\n", LinkListUtil.linkListToString(input));
        final ListNode listNode = new Solution().reverseBetween(input, m, n);
        System.out.printf("result:%s\n", LinkListUtil.linkListToString(listNode));
        System.out.printf("expect:%s\n", LinkListUtil.linkListToString(expect));
        assertTrue(LinkListUtil.compareLinkList(listNode, expect));
    }
}