package com.leetcode.array;

/**
 * Created by shihuashun on 2017/2/7.
 */
public class Solution414 {
    public static void main(String [] args) {
        int [] nums = {3,3};
//        int third = thirdMax(nums);
        int len = removeElement(nums, 5);
        System.out.print(len);
    }
    public static int thirdMax(int[] nums) {
        int first = nums[0];
        int second = 0x80000000;
        int third = 0x80000000;
        System.out.println(third);
        boolean hasThird = false;
        for(int i =0; i < nums.length; i++) {
            if(nums[i] > first) {
                if(third < second) {
                    third = second;
                }
                if(second < first) {
                    second = first;
                }
                first = nums[i];
            } else if(nums[i] > second && nums[i] != first) {
                if(third < second) {
                    third = second;
                }
                second = nums[i];
            } else if(nums[i] >= third && nums[i] != second && nums[i] != first) {
                third = nums[i];
            }
        }
        for(int num : nums) {
            if(num == third && third != second) {
                hasThird = true;
                break;
            }
        }
        return hasThird ? third : first;
    }

    public static int removeElement(int[] nums, int val) {
        int length = 0;
        if(nums.length == 1) {
            if(nums[0] != val) {
                length = 1;
            }
            return length;
        }
        for(int i = nums.length-1; i > 0; i--) {
            for(int j = 1 ; j <= i; j++)
                if(nums[j-1] == val && nums[j] != val) {
                    nums[j-1] = nums[j];
                    nums[j] = val;
                }
        }
        length = nums.length;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                length = i;
                break;
            }

        }
        return length;
    }
}