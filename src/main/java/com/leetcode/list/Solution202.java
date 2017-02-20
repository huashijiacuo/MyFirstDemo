package com.leetcode.list;

/**
 * Created by shihuashun on 2017/2/20.
 */
public class Solution202 {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.print("this is " + i +":");

            System.out.println(isHappy(i));
        }

    }
    public static boolean isHappy(int n) {
        int temp = 0;
        int sum = 0;
        boolean result = true;
        while (n != 1) {
            sum = 0;
            while (n != 0) {
                temp = n % 10;
                n = n / 10;
                sum += temp * temp;
            }
            n = sum;
           // System.out.println(n);
            if ( sum > 1 && sum < 10 && sum != 7) {
                result = false;
                break;
            }
        }
        return result;
    }
}
