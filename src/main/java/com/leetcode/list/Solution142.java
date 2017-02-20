package com.leetcode.list;

/**
 * Created by shihuashun on 2017/2/16.
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        if (head == null || head.next == null) {
            return head;
        }
        int count = 0;
        do {
            if (f == null || f.next == null)
                return null;
            f = f.next.next;
            s = s.next;
            count++;
        } while (f != s);
        f = head;
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s;
    }
}
