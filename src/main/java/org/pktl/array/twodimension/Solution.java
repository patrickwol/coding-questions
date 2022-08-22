package org.pktl.array.twodimension;

/**
 * 牛客 BM18 二维数组中的查找
 */
public class Solution {
    public boolean find(int target, int [][] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        int rows = array.length;
        int columns = array[0].length;
        for (int i = rows - 1, j = 0; i >= 0 && j < columns; ) {
            if (target > array[i][j]) {
                j++;
            } else if (target < array[i][j]) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }
}
