package org.pktl.linklist.sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.pktl.converter.LinkListConverter;
import org.pktl.util.LinkListUtil;
import org.pktl.util.ListNode;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "3 1, 1 3",
            "7 3 2 9 0 1 2, 0 1 2 2 3 7 9"
    })
    void sortInList(@ConvertWith(LinkListConverter.class) ListNode l1, @ConvertWith(LinkListConverter.class)ListNode l2) {
        final ListNode listNode = new Solution().sortInList(l1);
        assertTrue(LinkListUtil.compareLinkList(listNode, l2));
    }
}