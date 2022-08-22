package org.pktl.array.binary;

/**
 * 牛客 BM17 二分查找-I
 */
public class Solution {

    public int search (int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        int m = 0;
        if(target < nums[0] || target > nums[r]) {
            return -1;
        }
        while(l <= r) {
            m = (l+r) / 2;
            if(target == nums[m]) {
                return m;
            }
            if(target < nums[m]) {
                r = m-1;
                continue;
            }
            if(target > nums[m]) {
                l = m+1;
            }
        }
        return -1;
    }
}
