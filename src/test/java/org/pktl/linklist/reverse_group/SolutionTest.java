package org.pktl.linklist.reverse_group;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.pktl.converter.LinkListConverter;
import org.pktl.util.LinkListUtil;
import org.pktl.util.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "1 2 3 4 5,2,2",
            "1 2,2,2",
            "1 2 3,3,3",
            "1 2 3,4,0",
            "1,4,0",
            "1,2,0",
            "1,1,1",
    })
    void isEnoughNode(@ConvertWith(LinkListConverter.class) ListNode inp, int m, int exp) {
        final ListNode tailNode = new Solution().getTailNode(inp, m);
        int res = (tailNode == null) ? 0 : tailNode.val;
        assertEquals(exp, res);
    }

    @ParameterizedTest
    @CsvSource({
            "1 2 3 4 5,2,2 1 4 3 5",
            "1 2,2,2 1",
            "1 2 3,3,3 2 1",
            "1 2 3,4,1 2 3",
            "1,4,1",
            "1,2,1",
            "1,1,1",
            "1 2 3 4 5,3,3 2 1 4 5"
    })
    void reverseKGroup(@ConvertWith(LinkListConverter.class) ListNode inp, int m, @ConvertWith(LinkListConverter.class) ListNode exp) {
        assertTrue(LinkListUtil.compareLinkList(new Solution().reverseKGroup(inp, m), exp));
    }
}