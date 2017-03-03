package com.leetcode.list;

/**
 * Created by shihuashun on 2017/2/27.
 * 牛顿法
 */
public class Solution367 {
    public boolean isPerfectSquare(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num/x) / 2;
        }
        return x * x == num;
    }
}
