package org.pktl.array.find_peak;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.pktl.linklist.IntArrayConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "2 4 1 2 7 8 4, 5",
            "1 2 3 1, 2",
            "1, 0"
    })
    void findPeakElement(@ConvertWith(IntArrayConverter.class) int[] input, int expect) {
        final int i = new Solution().findPeakElement(input);
        assertEquals(expect, i);
    }
}