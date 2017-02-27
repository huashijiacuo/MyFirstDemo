package com.leetcode.list;

import com.forFriend.Main;

/**
 * Created by shihuashun on 2017/2/20.
 */
public class Solution441 {
    public static void main(String[] args) {
        int n = 1804289383;
        long k = (long) (Math.sqrt(n) * Math.sqrt(2));

        long count = k*(k+1)/2;
        if (count > (long)n )
            k--;
        System.out.println(k);

    }
}
