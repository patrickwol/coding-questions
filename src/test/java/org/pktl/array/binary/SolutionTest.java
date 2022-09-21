package org.pktl.array.binary;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.pktl.converter.IntArrayConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "-1 0 3 4 6 10 13 14, 13, 6",
            "-1 0 3 4, 2, -1"
    })
    void search(@ConvertWith(IntArrayConverter.class) int[] nums, int target, int expect) {
        final int search = new Solution().search(nums, target);
        assertEquals(search, expect);
    }

}