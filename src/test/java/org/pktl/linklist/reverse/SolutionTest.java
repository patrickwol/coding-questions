package org.pktl.linklist.reverse;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.pktl.converter.LinkListConverter;
import org.pktl.util.LinkListUtil;
import org.pktl.util.ListNode;

@Slf4j
class SolutionTest {

    @Test
    void reverseList() {
        ListNode l1 = null;
        System.out.println(new Solution().ReverseList(l1));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/linklist-reverse.csv")
    void reverseListCsv(@ConvertWith(LinkListConverter.class) ListNode input,
                        @ConvertWith(LinkListConverter.class) ListNode expect) {
        log.info("input:{}", LinkListUtil.linkListToString(input));
        log.info("expect:{}", LinkListUtil.linkListToString(expect));
        final ListNode resListNode = new Solution().ReverseList(input);
        log.info("result:{}", LinkListUtil.linkListToString(resListNode));
    }

}