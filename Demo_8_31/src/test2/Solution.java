package test2;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public static boolean canCross(int[] stones) {
        HashSet<Integer> set = new HashSet<>();
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            set.add(stones[i]);
        }
        int[][] dp = new int[n + 1][n + 2];

        dp[0][0] = dp[0][1] = 0;
        if (set.contains(1)) {
            dp[1][1] = 1;
        }
        boolean ans = false;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int a = dp[i - 1][j - 1];
                int b = dp[i - 1][j];
                int c = dp[i - 1][j + 1];
                if (set.contains(a) && a != 0 && set.contains(a + j)) {
                    dp[i][j] = a + j;
                }
                if (set.contains(b) && b != 0 && set.contains(b + j)) {
                    dp[i][j] = b + j;
                }
                if (set.contains(c) && c != 0 && set.contains(c + j)) {
                    dp[i][j] = c + j;
                }

                if (a + j == stones[n - 1] || b + j == stones[n - 1] || c + j == stones[n - 1]) {
                    ans = true;
                }
            }
            if (ans) {
                break;
            }
        }
        for (int i = 0; i <= n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] stones = {0, 1, 2, 3, 4, 8, 9, 11};
        System.out.println(canCross(stones));

    }
}
