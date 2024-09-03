package test1;

import java.util.Arrays;

public class Solution {
    public static int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        //dp[i][0] nums[i]作为山谷来结尾的最长摆动子序列长度
        //dp[i][1] nums[i]作为山锋来结尾的最长摆动子序列长度

        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }
                if (nums[j] < nums[i]) {
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(wiggleMaxLength(nums));

    }
}
