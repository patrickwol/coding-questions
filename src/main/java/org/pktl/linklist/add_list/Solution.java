package org.pktl.linklist.add_list;

import org.pktl.util.ListNode;

/**
 * 牛客 BM11 链表相加(二)
 */
public class Solution {

    public ListNode addInList (ListNode head1, ListNode head2) {
        ListNode r1 = reverse(head1);
        ListNode r2 = reverse(head2);
        ListNode r3 = new ListNode(-1);
        ListNode t3 = r3;
        int t = 0;
        while (r1 != null || r2 != null) {
            int v3 = t;
            if (r1 != null) {
                v3 += r1.val;
                r1 = r1.next;
            }
            if (r2 != null) {
                v3 += r2.val;
                r2 = r2.next;
            }
            if (v3 < 10) {
                t3.next = new ListNode(v3);
                t = 0;
            } else {
                t3.next = new ListNode(v3 % 10);
                t = 1;
            }
            t3 = t3.next;
        }
        if (t > 0) {
            t3.next = new ListNode(1);
        }
        return reverse(r3.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode p = null, c = head, t = null;
        while (c != null) {
            t = c.next;
            c.next = p;
            p = c;
            c = t;
        }
        return p;
    }
}
