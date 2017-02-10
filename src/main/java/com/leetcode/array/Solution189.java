package com.leetcode.array;

/**
 * Created by shihuashun on 2017/2/8.
 */
public class Solution189 {
    public static void main(String [] args) {
        int [] nums = {1, 2, 3};
        rotate(nums, 1);
        System.out.println(nums);
    }
    public static void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return;
        k = k % nums.length;
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
        reverse(nums, 0, nums.length-1);
        return;

    }
    public static void reverse(int[] num, int i, int j) {
        int temp = 0;
        while(i < j) {
            temp = num[j];
            num[j] = num[i];
            num[i] = temp;
            i++;
            j--;
        }
    }
}
