package org.pktl.linklist.del_duplicate;

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
            "1 1 2 2 3 5, 1 2 3 5",
            "1, 1",
            "1 5 5, 1 5",
            "1 1 1, 1"
    })
    void deleteDuplicates(@ConvertWith(LinkListConverter.class) ListNode l1, @ConvertWith(LinkListConverter.class)ListNode l2) {
        ListNode listNode = new Solution().deleteDuplicates2(l1);
        System.out.println(LinkListUtil.linkListToString(listNode));
        assertTrue(LinkListUtil.compareLinkList(listNode, l2));
    }
}