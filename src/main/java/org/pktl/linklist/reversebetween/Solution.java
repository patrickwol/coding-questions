package org.pktl.linklist.reversebetween;

import org.pktl.util.ListNode;

/**
 * 牛客
 * BM2 链表内指定区间反转
 */
public class Solution {
    /**
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        //为了处理m=1的情况,从创建的头结点开始遍历
        ListNode head0 = new ListNode(0);
        head0.next = head;
        int i = 0;
        ListNode p1 = head0, p2 = null, m1 = null, m2 = null, c = head0, t = null, pre = null;
        while (c != null && i <= n) {
            if (i < m) {
                i++;
                pre = c;
                c = c.next;
                p1 = pre;
            } else if (i == m) {
                i++;
                m1 = c;
                pre = c;
                c = c.next;
            } else if (i < n) {
                i++;
                t = c.next;
                c.next = pre;
                pre = c;
                c = t;
            } else if (i == n) {
                i++;
                m2 = c;
                p2 = c.next;
                c.next = pre;
            }
        }
        p1.next = m2;
        m1.next = p2;
        return head0.next;
    }
}