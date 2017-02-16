package com.leetcode.list;

/**
 * Created by shihuashun on 2017/2/15.
 */


/**
 * Definition for singly-linked list.
 *  */

public class Solution21 {
    public static void main(String[] args) {
        Solution21 s = new Solution21();
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);
        ListNode head = s.mergeTwoLists(l1, l2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode p = null;
        if(l1 == null) {
            head = l2;
        } else if (l2 == null) {
            head = l1;
        } else {
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    if(head == null) {
                        head = l1;
                        p = l1;
                        l1 = l1.next;
                    } else {
                        p.next = l1;
                        l1 = l1.next;
                        p = p.next;
                    }
                } else {
                    if(head == null) {
                        head = l2;
                        p = l2;
                        l2 = l2.next;
                    } else {
                        p.next = l2;
                        l2 = l2.next;
                        p = p.next;
                    }
                }
            }
            ListNode node = (l1 != null ? l1:l2);
            p.next = node;
        }
        return head;
    }
}
