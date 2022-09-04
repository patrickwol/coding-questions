package org.pktl.string.permutation;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void permutation() {
//        System.out.println(new Solution().Permutation("aac"));
//        System.out.println(new Solution().Permutation("abc"));
        Long startTime = System.currentTimeMillis();
        new Solution().Permutation("qwertyuio");
        Long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}