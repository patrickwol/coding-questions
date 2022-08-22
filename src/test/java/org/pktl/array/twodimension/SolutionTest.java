package org.pktl.array.twodimension;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void find() {
        int[][] ta = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15},
        };
        assertTrue(new Solution().find(7, ta));
        assertFalse(new Solution().find(3, ta));
        int[][] ta1 = {{1,2,8,9}};
        assertFalse(new Solution().find(3, ta1));
        assertTrue(new Solution().find(8, ta1));
        assertTrue(new Solution().find(9, ta1));
    }
}