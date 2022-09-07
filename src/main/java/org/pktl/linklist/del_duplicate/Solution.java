package org.pktl.linklist.del_duplicate;

import org.pktl.util.ListNode;

/**
 * 牛客 BM15 删除有序链表中重复的元素-I
 */
public class Solution {

    public ListNode deleteDuplicates (ListNode head) {
        ListNode t = head;
        while (t != null) {
            ListNode n = t.next;
            if (n == null) {
                break;
            }
            while (n != null && n.val == t.val) {
                n = n.next;
            }
            t.next = n;
            t = t.next;
        }
        return head;
    }

    public ListNode deleteDuplicates2 (ListNode head) {
        ListNode t = head;
        while (t != null && t.next != null) {
            if (t.val == t.next.val) {
                t.next = t.next.next;
            } else {
                t = t.next;
            }
        }
        return head;
    }
}
