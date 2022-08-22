package org.pktl.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.text.CharPool;
import cn.hutool.core.util.StrUtil;

import java.util.List;

public class LinkListUtil {

    public static ListNode stringToLinkList(String s) {
        return stringToLinkList(s, CharPool.SPACE);
    }

    public static ListNode stringToLinkList(String s, char split) {
        s = StrUtil.trim(s);
        if (StrUtil.isBlank(s)) {
            return null;
        }
        final List<Integer> list = StrUtil.split(s, split, -1, true, Convert::toInt);
        ListNode head = new ListNode(list.get(0));
        if (list.size() == 1) {
            return head;
        }
        ListNode t = head;
        for (int i = 1; i < list.size(); i++) {
            t.next = new ListNode(list.get(i));
            t = t.next;
        }
        return head;
    }

    public static String linkListToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode t = head;
        while (t != null) {
            sb.append(t.val).append(" ");
            t = t.next;
        }
        return StrUtil.trim(sb);
    }

    public static Boolean compareLinkList(ListNode head1, ListNode head2) {
        ListNode c1=head1,c2=head2;
        while (c1 != null && c2 != null) {
            if (c1.val == c2.val) {
                c1 = c1.next;
                c2 = c2.next;
            } else {
                return Boolean.FALSE;
            }
        }
        if (c1 != null || c2 != null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
