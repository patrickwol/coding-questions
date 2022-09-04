package org.pktl.linklist.reverse_group;

import org.pktl.util.ListNode;

/**
 * 牛客
 * BM3 链表中的节点每k个一组翻转
 */
public class Solution {

    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (getTailNode(head, k) == null || k==1) {
            return head;
        }
        ListNode resHead = getTailNode(head, k);
        ListNode t = resHead.next;
        ListNode th = doReverse(head, k);
        while (t != null) {
            final ListNode tailNode = getTailNode(t, k);
            if (tailNode != null) {
                th.next=tailNode;
                ListNode nex = tailNode.next;
                th = doReverse(t, k);
                t=nex;
            } else {
                th.next = t;
                t =null;
            }
        }
        return resHead;
    }

    /**
     * 获得第k个节点,如果超出长度返回null
     * @param head
     * @param k
     * @return
     */
    ListNode getTailNode(ListNode head, int k) {
        ListNode t = head,pre=null;
        if (head == null) {
            return null;
        }
        int i = 1;
        while (i <= k) {
            if (t != null) {
                pre=t;
                t = t.next;
            } else {
                return null;
            }
            i++;
        }
        return pre;
    }

    /**
     * 从head开始翻转k个节点
     * @param head
     * @param k
     * @return
     */
    ListNode doReverse(ListNode head, int k) {
        ListNode c=head,pre=null,t=null;
        for (int i = 1; i <= k; i++) {
            t=c.next;
            c.next=pre;
            pre=c;
            c=t;
        }
        return head;
    }

}
