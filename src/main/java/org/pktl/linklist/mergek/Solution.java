package org.pktl.linklist.mergek;

import org.pktl.util.ListNode;

import java.util.ArrayList;

/**
 * 牛客 BM5 合并k个已排序的链表
 */
public class Solution {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        final int size = lists.size();
        return merge(lists, 0, size - 1);
    }

    private ListNode merge(ArrayList<ListNode> list, int i, int j) {
        if (i == j) {
            return list.get(i);
        }
        if (i + 1 == j) {
            return mergeTwo(list.get(i), list.get(j));
        }
        int m = (i + j) / 2;
        final ListNode l1 = merge(list, i, m);
        final ListNode l2 = merge(list, m + 1, j);
        return mergeTwo(l1, l2);
    }


    private ListNode mergeTwo(ListNode list1, ListNode list2) {
        ListNode h = new ListNode(0);
        ListNode c = h;
        ListNode t1 = list1;
        ListNode t2 = list2;
        while (t1 != null && t2 != null) {
            if (t1.val <= t2.val) {
                c.next = t1;
                t1 = t1.next;
            } else {
                c.next = t2;
                t2 = t2.next;
            }
            c=c.next;
        }
        if (t1 != null) {
            c.next = t1;
        }
        if (t2 != null) {
            c.next = t2;
        }
        return h.next;
    }
}
