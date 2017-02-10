package com.leetcode.array;

/**
 * Created by shihuashun on 2017/2/10.
 */
public class Solution53 {
    public static void main(String[] args) {
        Solution53 s = new Solution53();
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = s.maxSubArray(nums);
        System.out.println(result);
    }
    public int maxSubArray(int[] nums) {
        int result = 0;
        int len = nums.length;
        result = getMax(nums,0, (0 + len-1)/2, len - 1);
        return result;
    }

    public int getMax(int[] nums, int left, int middle, int right) {
        int leftMax = 0;
        int rightMax = 0;
        int middleMax = 0;
        if(left == middle && middle == right) {
            return nums[left];
        }
        if(left == middle) {
            leftMax = nums[left];
        } else {
            leftMax = getMax(nums, left, (left + middle) / 2, middle);
        }

        if(right == middle) {
            rightMax = nums[right];
        } else {
            rightMax = getMax(nums, middle + 1, (middle + 1 + right) / 2, right);
        }
        middleMax = nums[middle] + nums[middle+1];
        int temp = middleMax;
        for(int i = middle-1; i >= left; i--) {
            temp = temp + nums[i];
            if(temp > middleMax) {
                middleMax = temp;
            }
        }
        temp = middleMax;
        for(int i = middle + 2; i <= right; i++) {
            temp = temp + nums[i];
            if(temp > middleMax) {
                middleMax = temp;
            }
        }

        return getMax3(leftMax, rightMax, middleMax);
    }
    public int getMax3(int m, int n, int p) {
        int max = m;
        max = m > n ? m : n;
        max = max > p ? max : p;
        return max;
    }
}
