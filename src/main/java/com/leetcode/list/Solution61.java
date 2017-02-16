package com.leetcode.list;

/**
 * Created by shihuashun on 2017/2/15.
 */
public class Solution61 {
    public static void main(String[] args) {
        Solution61 s = new Solution61();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode head = s.rotateRight( l1, 1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        int count = 1;
        ListNode p = head;
        if (p == null || p.next == null) {
            return head;
        }
        while(p.next != null) {
            count++;
            p = p.next;
        }
        k = count - k%count;
        if (k%count == 0) {
            return head;
        }
        p.next = head;
        while (k != 0) {
            p = p.next;
            k--;
        }
        head = p.next;
        p.next = null;
        return head;

    }
}
