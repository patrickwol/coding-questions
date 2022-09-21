package org.pktl.linklist.palindrome;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.pktl.converter.LinkListConverter;
import org.pktl.util.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "1 2 3 2 1, true",
            "1 2 2 1, true",
            "1 2 1 1, false",
    })
    void isPail(@ConvertWith(LinkListConverter.class) ListNode listNode, boolean expect) {
        boolean pail = new Solution().isPail(listNode);
        assertEquals(pail, expect);
    }
}