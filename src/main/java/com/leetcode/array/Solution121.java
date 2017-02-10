package com.leetcode.array;

/**
 * Created by shihuashun on 2017/2/10.
 */
public class Solution121 {
    public static void main(String[] args) {
        int m = 100;
        int [] nums = {7, 1, 5, 3, 6, 4};
        Solution121 s = new Solution121();
        m = s.maxProfit(nums);
        System.out.println(m);
    }
    public int maxProfit(int[] prices) {
        int result = 0;
        int len = prices.length;
        int [] minus = new int[len-1];
        for(int i = 0; i <= len-2; i++) {
            minus[i] = prices[i+1] - prices[i];
        }
        result = getMax(minus, 0, (0+len-2)/2,len-2);
        if (result < 0) {
            result = 0;
        }
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
