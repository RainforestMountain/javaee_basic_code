package test8;

public class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;

        int[][] dp = new int[n][n];//dp[i][j]拆分三角形的最小值


        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                int num = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    num = Math.min(num, values[i] * values[k] * values[j] + dp[i][k] + dp[k][j]);
                }
                dp[i][j] = num;
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minScoreTriangulation(new int[]{3, 7, 4, 5}));
    }
}
