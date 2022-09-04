package org.pktl.array.find_peak;

/**
 * 牛客 BM19 寻找峰值
 */
public class Solution {
    /**
     * @param nums int整型一维数组
     * @return int整型
     */
    public int findPeakElement (int[] nums) {
        if(nums == null || nums.length == 1) {
            return 0;
        }
        int l = 0;
        int r = nums.length-1;
        int m;
        while(l < r) {
            m = (l+r)/2;
            if(nums[m] > nums[m+1]) {
                r = m;
            } else {
                l = m+1;
            }
        }
        return r;
    }
}