package org.pktl.array.compareversion;

/**
 * 牛客 BM22 比较版本号
 */
public class Solution {

    public int compare (String version1, String version2) {
        final String[] v1 = version1.split("\\.");
        final String[] v2 = version2.split("\\.");
        int x = v1.length, y = v2.length;
        for (int i=0; i<x||i<y; i++) {
            int m = i < x ? Integer.parseInt(v1[i]) : 0;
            int n = i < y ? Integer.parseInt(v2[i]) : 0;
            if (m > n) {
                return 1;
            } else if (m < n) {
                return -1;
            }
        }
        return 0;
    }
}
