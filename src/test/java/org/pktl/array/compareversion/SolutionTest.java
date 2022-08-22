package org.pktl.array.compareversion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "1.1, 2.1, -1",
            "1.1, 1.01, 0",
            "1.1, 1.1.1, -1",
            "2.0.1, 2, 1",
            "0.226, 0.36, 1",
            "1.0, 1.0.0, 0"
    })
    void compare(String version1, String version2, int expect) {
        final int compare = new Solution().compare(version1, version2);
        assertEquals(expect, compare);
    }
}