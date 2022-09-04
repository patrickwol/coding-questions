package org.pktl.linklist.remove_from_end;

import org.pktl.util.ListNode;

/**
 * 牛客 BM9 删除链表的倒数第n个节点
 */
public class Solution {

    public ListNode removeNthFromEnd (ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        ListNode vHead = new ListNode(0);
        vHead.next = head;
        ListNode l1 = vHead;
        ListNode l2 = l1;
        for (int i = 0; i < n; i++) {
            if (l1 == null) {
                return null;
            }
            l1 = l1.next;
        }
        while (l1.next != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        l2.next = l2.next.next;
        return vHead.next;
    }
}
