package com.leetcode.list;

/**
 * Created by shihuashun on 2017/2/20.
 */
public class Solution9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-2147447412));
        Math.sqrt(123);
    }
    public static boolean isPalindrome(int x) {
        int result = 0;
        int temp = x;
        while (temp != 0) {
            result = result*10 + (temp%10);
            temp /= 10;
        }
        return result == x;
    }
}
