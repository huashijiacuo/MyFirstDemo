package com.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by shihuashun on 2017/2/8.
 */
public class Solution448 {
    public static void main(String [] args) {
        int [] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = findDisappearedNumbers(nums);
        System.out.println(list);
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set setAll = new HashSet();
        Set setNums = new HashSet();
        for(int i = 0; i < nums.length; i++) {
            setAll.add(i+1);
            setNums.add(nums[i]);
        }
        setAll.removeAll(setNums);
        List<Integer> list = new ArrayList<Integer>();
        list.addAll(setAll);
        return list;
    }
}
