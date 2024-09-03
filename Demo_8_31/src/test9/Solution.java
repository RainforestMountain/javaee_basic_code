package test9;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public int minCost(int n, int[] cuts) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n + 1 - 3; i >= 0; i--) {
            for (int j = i + 2; j <= n; j++) {
                int value = Integer.MAX_VALUE / 2;
                boolean flag = false;
                for (int cut : cuts) {
                    if (cut > i && cut < j) {
                        flag = true;
                        value = Math.min(value, (j - i) + dp[i][cut] + dp[cut][j]);
                    }
                }
                if (!flag) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = value;
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return dp[0][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCost(9, new int[]{5, 6, 1, 4, 2}));
    }
}
