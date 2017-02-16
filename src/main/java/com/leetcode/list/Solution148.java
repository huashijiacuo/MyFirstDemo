package com.leetcode.list;

import java.util.List;

/**
 * Created by shihuashun on 2017/2/15.
 */
public class Solution148 {
    public static void main(String[] args) {
        Solution148 s = new Solution148();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        ListNode result = s.sortList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public ListNode sortList(ListNode head) {
        int count = 1;
        ListNode p = head;
        if (p == null || p.next == null) {
            return head;
        }
        while (p.next != null) {
            count++;
            p = p.next;
        }
        return sort(head, p, count);
    }

    public ListNode sort(ListNode firstNode, ListNode lastNode, int k) {
        ListNode head = null;
        if (firstNode.equals(lastNode)) {
            return firstNode;
        }
        else {
            ListNode middle = firstNode;
            int m = k/2 - 1;
            while (m-- != 0) {
                middle = middle.next;
            }
            ListNode middle2 = middle.next;
            middle.next = null;
            ListNode left = sort(firstNode, middle, k/2 );
            ListNode right = sort(middle2, lastNode, k-k/2);
            ListNode merge = null;
            while (left != null && right != null) {
                if(left.val < right.val) {
                    if(merge == null) {
                        merge = left;
                        head = left;
                    } else {
                        merge.next = left;
                        merge = merge.next;
                    }
                    left = left.next;
                } else {
                    if(merge == null) {
                        merge = right;
                        head = right;
                    } else {
                        merge.next = right;
                        merge = merge.next;
                    }
                    right = right.next;
                }
            }
            merge.next = (left != null ? left : right);
        }
        return head;
    }
}
