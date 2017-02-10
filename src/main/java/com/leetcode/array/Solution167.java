package com.leetcode.array;

/**
 * Created by shihuashun on 2017/2/10.
 */
public class Solution167 {
    public static void main(String[] args) {
        Solution167 s = new Solution167();
        int [] nums = {2, 3, 4};
        int target = 6;
        int [] rs;
        rs = s.twoSum(nums, target);
        System.out.println(rs);
    }

    public int[] twoSum(int[] numbers, int target) {
        int [] result = new int[2];
        int len = numbers.length;
        int left = 0;
        int right = len-1;
        while(left < right) {
            if(numbers[left] + numbers[right] == target) {
                break;
            } else if(numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        result[0] = left+1;
        result[1] = right+1;
        return result;
    }
}
