package com.leetcode.list;

/**
 * Created by shihuashun on 2017/2/20.
 */
public class Solution231 {
    public static void main(String[] args) {
        int n = 1073741825;
        System.out.println(isPowerOfTwo(n));
    }
    public static boolean isPowerOfTwo(int n) {
        int m = 1;
        while (m < n && m > 0) {
            m = m << 1;
        }
        if (m == n)
            return true;
        else
            return false;
    }
}
