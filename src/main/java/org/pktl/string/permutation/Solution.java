package org.pktl.string.permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 牛客 BM58 字符串的排列
 */
public class Solution {

    public ArrayList<String> Permutation (String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return list;
        }
        Set<String> set = new HashSet<>();
        doPermuation(set, str.toCharArray(), 0);
        list.addAll(set);
        return list;
    }

    private void doPermuation(Set<String> set, char[] c, int l) {
        if (l == c.length-1) {
            set.add(String.valueOf(c));
            return;
        }
        for (int i = l; i < c.length; i++) {
            swap(c, l, i);
            doPermuation(set, c, l + 1);
            swap(c, l, i);

        }
    }

    private void swap(char[] c, int i, int j) {
        if (i == j) {
            return;
        }
        final char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}
