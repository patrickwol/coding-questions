package org.pktl.linklist.sort;

import org.pktl.util.ListNode;

/**
 * 牛客 BM12 单链表的排序
 */
public class Solution {

    public ListNode sortInList (ListNode head) {
        return doSort(head, null);
    }

    private ListNode doSort(ListNode head, ListNode tail) {
        if (head == tail || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head, tail);
        ListNode t = mid.next;
        mid.next = null;
        final ListNode l1 = doSort(head, mid);
        final ListNode l2 = doSort(t, null);
        return merge(l1, l2);
    }

    private ListNode findMid(ListNode listNode, ListNode tail) {
        ListNode fast = listNode;
        ListNode slow = listNode;
        while (fast.next != tail && fast.next.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
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
