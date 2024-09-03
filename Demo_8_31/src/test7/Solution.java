package test7;

import java.util.Arrays;

public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        func(matrix, 0, 0, dp);
        boolean[][] visited = null;
//        for (int i = 0; i < m; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return dp[0][0];
    }

    public int func(int[][] matrix, int i, int j, int[][] dp) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        dp[i][j] = 0;
        for (int t = 0; t < 4; t++) {
            int ni = i + dx[t];
            int nj = j + dy[t];
            if (check(ni, nj, m, n) && matrix[ni][nj] > matrix[i][j]) {
                dp[i][j] = Math.max(dp[i][j], 1 + func(matrix, ni, nj, dp));
            } else {
                dp[i][j] = Math.max(dp[i][j], 0 + func(matrix, ni, nj, dp));
            }
        }
        return dp[i][j];
    }

    public boolean check(int ni, int nj, int m, int n) {
        return ni >= 0 && ni < m && nj >= 0 && nj < n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestIncreasingPath(new int[][]{
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}}));
    }
}
