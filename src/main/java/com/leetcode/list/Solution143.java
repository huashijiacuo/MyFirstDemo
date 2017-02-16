package com.leetcode.list;

/**
 * Created by shihuashun on 2017/2/16.
 */
public class Solution143 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        Solution143 s = new Solution143();
        s.reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode middle = getMiddle(head);
        ListNode mh = reverse(middle);
        head = merge(head, mh);
        return;

    }

    public ListNode getMiddle(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode f = head;
        ListNode s = head;
        while(f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
        }
        head = s.next;
        s.next = null;
        return head;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode h = head;
        ListNode p = head.next;
        h.next = null;
        ListNode temp = null;
        while (p != null) {
            temp = p.next;
            p.next = h;
            h = p;
            p = temp;
        }
        return h;
    }

    public ListNode merge(ListNode left, ListNode right) {
        if(left == null || right == null) {
            return left;
        }
        ListNode head = left;
        left = left.next;
        head.next = right;
        ListNode p = right;
        right = right.next;
        while (left != null && right != null) {
            p.next = left;
            left = left.next;
            p.next.next = right;
            p = right;
            right = right.next;

        }
        if (left != null) {
            p.next = left;
        }
        if (right != null) {
            p.next = right;
        }
        return head;
    }
}
