package org.pktl.linklist.mergetwo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.pktl.linklist.LinkListConverter;
import org.pktl.util.LinkListUtil;
import org.pktl.util.ListNode;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "1 3 5, 2 4 6, 1 2 3 4 5 6",
            "-1 2 4, 1 3 4, -1 1 2 3 4 4",
            "1 5, 2 3 7, 1 2 3 5 7",
            "-9 0 1, 4 7 9, -9 0 1 4 7 9"
    })
    void merge(@ConvertWith(LinkListConverter.class)ListNode l1, @ConvertWith(LinkListConverter.class)ListNode l2,
               @ConvertWith(LinkListConverter.class)ListNode expect) {
        final ListNode merge = new Solution().merge(l1, l2);
        assertTrue(LinkListUtil.compareLinkList(merge, expect));
    }
}