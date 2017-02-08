package com.leetcode.array;

import java.util.*;

/**
 * Created by shihuashun on 2017/2/7.
 */
public class Solution217 {
    public static void main(String [] args) {
        int [] nums = {3, 1, 4, 4};
        boolean flag = containsDuplicate(nums);
        System.out.print(flag);
    }
    public static boolean containsDuplicate(int[] nums) {

        if(nums == null || nums.length == 0) {
            return false;
        }
        Set<Object> set = new HashSet<Object>();
        List list = Arrays.asList(nums);
        set.addAll(list);
        if(nums.length == set.size()) {
            return false;
        } else {
            return true;
        }
    }
}
