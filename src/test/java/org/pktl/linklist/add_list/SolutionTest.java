package org.pktl.linklist.add_list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.pktl.linklist.LinkListConverter;
import org.pktl.util.LinkListUtil;
import org.pktl.util.ListNode;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "1 3 5, 2 4 6",
            "9 3 7, 6 3"
    })
    void addInList(@ConvertWith(LinkListConverter.class) ListNode l1, @ConvertWith(LinkListConverter.class)ListNode l2) {
        final ListNode listNode = new Solution().addInList(l1, l2);
        System.out.println(LinkListUtil.linkListToString(listNode));
    }
}