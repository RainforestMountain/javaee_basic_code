package test5;

import java.util.Arrays;

public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        int[][] f = new int[n][n];//nums[i], nums[j]为等差序列头尾的等差序列数

        //f

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = dp[i + 1][j] + dp[i][j - 1];

            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfArithmeticSlices(new int[]{7,7,7,7,7}));
    }
}
