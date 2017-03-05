package com.leetcode.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shihuashun on 2017/3/5.
 */
public class Solution241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left  = diffWaysToCompute(input.substring(0, i-1));
                List<Integer> right = diffWaysToCompute(input.substring(i+1, input.length()));
                for (int l : left) {
                    for (int r : right) {
                        switch (ch) {
                            case '+':
                                res.add(r+l);
                                break;
                            case '-':
                                res.add(l+r);
                                break;
                            case '*':
                                res.add(l*r);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        if (res.size() == 0)
            res.add(Integer.valueOf(input));
        return res;
    }
}
