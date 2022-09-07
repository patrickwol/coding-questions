package org.pktl.linklist.odd_even;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.pktl.linklist.LinkListConverter;
import org.pktl.util.LinkListUtil;
import org.pktl.util.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "1 2 3 4 5 6, 1 3 5 2 4 6"
    })
    void oddEvenList(@ConvertWith(LinkListConverter.class) ListNode l1, @ConvertWith(LinkListConverter.class)ListNode l2) {
        ListNode listNode = new Solution().oddEvenList(l1);
        System.out.println(LinkListUtil.linkListToString(listNode));
        assertTrue(LinkListUtil.compareLinkList(listNode, l2));
    }
}