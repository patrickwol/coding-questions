package org.pktl.linklist.palindrome;

import org.pktl.util.ListNode;

/**
 * 牛客 BM13 判断一个链表是否为回文结构
 */
public class Solution {

    public boolean isPail(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode f = head, s = head;

        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        ListNode r = reverse(s);
        while (r != null) {
            if (r.val != head.val) {
                return false;
            }
            r = r.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode listNode) {
        ListNode c = listNode, p = null, n = null;
        while (c != null) {
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }
}
