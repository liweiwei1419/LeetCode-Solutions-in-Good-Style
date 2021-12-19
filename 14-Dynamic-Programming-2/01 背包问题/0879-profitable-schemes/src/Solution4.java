public class Solution4 {


    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int len = group.length;

        int mod = 1000000000 + 7;
        int[][][] dp = new int[len + 1][P + 1][G + 1];


        // 初始化
        dp[0][0][G] = 1;

        for (int i = 1; i <= len; i++) {
            int pItem = profit[i - 1];
            int groupItem = group[i - 1]; // 要用多少人

            //
            for (int j = 0; j <= P; j++) {
                int p2 = Math.min(j + pItem, P);

                for (int g = 0; g <= G; g++) {
                    if (g >= groupItem) {
                        dp[i][p2][g - groupItem] = (dp[i][p2][g - groupItem] + dp[i - 1][j][g]) % mod;
                    }
                    dp[i][j][g] = (dp[i][j][g] + dp[i - 1][j][g]) % mod;
                }
            }
        }

        int res = 0;
        for (int x : dp[len][P]) {
            res = (res + x) % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        int g = 10;
        int p = 5;
        int[] group = {2, 3, 5};
        int[] profit = {6, 7, 8};
        Solution4 solution4 = new Solution4();
        int res = solution4.profitableSchemes(g, p, group, profit);
        System.out.println(res);
    }
}
