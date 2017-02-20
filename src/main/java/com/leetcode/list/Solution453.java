package com.leetcode.list;

/**
 * Created by shihuashun on 2017/2/20.
 */
public class Solution453 {
    public static void main(String[] args) {
        int [] nums = {1, 2, 3};
        int result = minMoves(nums);
        System.out.println(result);
    }
    public static int minMoves(int[] nums) {
        int min = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        int result = sum - min * nums.length;
        return result;
    }
}
