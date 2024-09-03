package test4;

import java.util.*;

public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = needs.size();
        int[] dp = new int[(1 << n) - 1];
        Arrays.fill(dp, -1);
        return func(0, 0, price, special, needs, dp);
    }


    //以i开始,状态为s的情况, 达到目标所花的最低价格
    public int func(int s, int i, List<Integer> price, List<List<Integer>> special, List<Integer> needs, int[] dp) {
        int n = needs.size();
        //满足第i位商品
        if (i >= n) {
            return 0;
        }
        //已经满足了
        if ((s & (1 << i)) != 0) {
            return 0;
        }
        //计算过了
        if (dp[s] != -1) {
            return dp[s];
        }
        //计算大礼包是否合算, 1.大礼包的价格是否小于每个商品单独买的总价格
        List<Integer> option1 = new ArrayList<>(needs);
        Collections.sort(special, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(o1.size() - 1) - o2.get(o2.size() - 1);
            }
        });
        int cost = 0;
        for (int j = 0; j < special.size(); j++) {
            while (true) {
                boolean ans = true;
                for (int k = 0; k < option1.size(); k++) {
                    if (special.get(j).get(k) > option1.get(k)) {
                        ans = false;
                        break;
                    }
                    int val = option1.get(k);
                    option1.set(k, val - special.get(j).get(k));
                }
                if (!ans) {//不符合要求不能买
                    break;
                }
                cost += special.get(j).get(special.get(j).size() - 1);
            }
        }

        if (option1.get(i) != 0) {
            cost += option1.get(i) * price.get(i);
            option1.set(i, 0);
        }


        int next = 0;
        for (int j = 0; j < needs.size(); j++) {
            if (needs.get(j) == 0) {//第j位已经满足了
                next = next ^ (1 << j);
            }
        }
        dp[s] = cost + func(next, i + 1, price, special, needs, dp);
        return dp[s];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> price = new ArrayList<>(List.of(2, 5));
        List<Integer> needs = new ArrayList<>(List.of(3, 2));
        List<List<Integer>> special = new ArrayList<>();
        special.add(new ArrayList<>(List.of(3, 0, 5)));
        special.add(new ArrayList<>(List.of(1, 2, 10)));

        System.out.println(solution.shoppingOffers(price, special, needs));
    }

}
