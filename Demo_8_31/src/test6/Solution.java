package test6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return func(expression);
    }

    HashMap<String, List<Integer>> dp = new HashMap<>();

    public List<Integer> func(String expression) {
        if (expression.length() == 1 || expression.length() == 2) {
            return List.of(Integer.parseInt(expression));
        }
        if (dp.containsKey(expression)) {
            return dp.get(expression);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < expression.length(); i ++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                List<Integer> left = func(expression.substring(0, i));
                List<Integer> right = func(expression.substring(i + 1));
                for (Integer lval : left) {
                    for (Integer rval : right) {
                        if (expression.charAt(i) == '+') {
                            res.add(lval + rval);
                        } else if (expression.charAt(i) == '-') {
                            res.add(lval - rval);
                        } else {
                            res.add(lval * rval);
                        }
                    }
                }
            }
        }
        dp.put(expression, res);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute("2*3-4*5"));
    }
}
