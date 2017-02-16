package com.leetcode.list;

/**
 * Created by shihuashun on 2017/2/16.
 */
public class Solution147 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(6);
        //head.next.next = new ListNode(1);

        Solution147 s = new Solution147();
        ListNode result = s.insertionSortList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode h = head;
        ListNode p = head.next;
        ListNode n = p;
        h.next = null;
        while (p != null) {
            n = n.next;
            p.next = null;
            if (p.val < h.val) {
                p.next = h;
                h = p;
                head = p;
                p = n;
                continue;
            }
            while (h.next != null ) {
                if(h.next.val < p.val) {
                    h = h.next;
                } else {
                    p.next = h.next;
                    h.next = p;
                    p = n;
                    break;
                }
            }
            if (h.next == null) {
                h.next = p;
                p = n;
            }
            h = head;
        }
        return head;
    }
}
