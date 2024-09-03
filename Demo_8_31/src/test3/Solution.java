package test3;

public class Solution {
    public static int countArrangement(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[(1 << n)];
        dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            //拿到状态s 其中1 的个数
            int num = Integer.bitCount(i);
            //这次要选择第num + 1的数字了
            for (int j = 0; j < n; j++) {
                //看j + 1有没有被选, 第j位表示j + 1有没有被选择
                if ((i & (1 << j)) == 0 && ((num + 1) % (j + 1) == 0 || ( j + 1) % (num + 1) == 0)) {
                    int s = i ^ (1 << j);//第j位被选择的状态
                    dp[s] += dp[i];
                }
            }
        }

        return dp[(1 << n) - 1];
    }

    public static void main(String[] args) {
        System.out.println(countArrangement(4));
    }


}
