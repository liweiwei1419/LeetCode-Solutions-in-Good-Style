import java.util.Arrays;

public class Solution9 {

    // 参考资料：https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/

    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][] dp = new int[len][len];
        // 先列再行
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                int x = ((i + 2) <= j) ? dp[i + 2][j] : 0;
                int y = ((i + 1) <= (j - 1)) ? dp[i + 1][j - 1] : 0;
                int z = (i <= (j - 2)) ? dp[i][j - 2] : 0;

                dp[i][j] = Math.max(piles[i] + Math.min(x, y), piles[j] + Math.min(y, z));
            }
        }

        for (int i = 0; i < len; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[0][len - 1] > 0;
    }

    public static void main(String[] args) {
        int[] piles = {5, 3, 4, 5};
        Solution9 solution = new Solution9();
        boolean res = solution.stoneGame(piles);
        System.out.println(res);
    }
}
